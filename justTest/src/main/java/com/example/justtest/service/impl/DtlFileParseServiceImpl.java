package com.example.justtest.service.impl;

import com.example.justtest.domain.CheckPathDetialDO;
import com.example.justtest.domain.DtlFileInfDOPerson;
import com.example.justtest.enums.ProcessStsCdEnum;
import com.example.justtest.service.IDtlFileInfoBatchService;
import com.example.justtest.service.IDtlFileParseCibService;
import com.example.justtest.service.IOfficialCheckCollectService;
import com.example.justtest.service.IOfficialCheckPathDetailService;
import com.example.justtest.utils.DateUtil.DateUtil;
import com.example.justtest.utils.FileUtil;
import com.example.justtest.utils.StringUtils;
import com.example.justtest.utils.ZipUtil;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: LIVI
 * @Time: 2023/03/16  17:35
 * @Description: 解析zip文件内容入库，两个不同的listA和listB，将B中的与msgId与A中的入库
 */
@Service
public class DtlFileParseServiceImpl implements IDtlFileParseCibService {
    private static final Logger logger = LoggerFactory.getLogger(DtlFileParseServiceImpl.class);

    @Autowired
    private IOfficialCheckCollectService checkCollectService;
    @Autowired
    private IDtlFileInfoBatchService dtlFileInfoBatchService;
    @Autowired
    private IOfficialCheckPathDetailService officialCheckPathDetailService;


    @Override
    public void parse(String settleDate, String crdtParty) throws Exception {
        /**
         *从数据库中获取需要解析的文件的路径
         * */
        List<DtlFileInfDOPerson> fileInfDOPersonList = dtlFileInfoBatchService.queryDtlFileInfoBatchIdStatus(settleDate, crdtParty);
        //定义变量标识是否存在解析失败的文件
        boolean hasParseFile = false;
        /**
         * start——开始解压文件
         * */
        if (fileInfDOPersonList != null && !fileInfDOPersonList.isEmpty()) {
            for (DtlFileInfDOPerson fileInfDOPerson : fileInfDOPersonList) {
                //拿到文件在磁盘上的源路径
                String filePath = fileInfDOPerson.getSrcFilePath();
                //更换文件后缀，拿到解压后的文件名
                //文件后缀为zip，不直接使用字符替换，避免出现路径中间出现.zip
                String destPath = null;
                String extension = FilenameUtils.getExtension(filePath).toLowerCase();
                if (!"zip".equals(extension)) {
                    logger.error("对账明细文件格式不对，文件必须是.zip文件");
                    throw new Exception("文件后缀不合法");
                }

                int indexZip = filePath.lastIndexOf(".zip");
                //根据解压出来的文件的后缀进行修改
                destPath = filePath.substring(0, indexZip) + ".CSV";
                File destFile = new File(destPath);
                //判断文件是否存在，如果存在，先删除目标文件
                if (destFile.exists()) {
                    destFile.getParentFile().mkdirs();
                } else {
                    FileUtil.delete(destFile);
                }
                try {
                    //执行解压文件
                    ZipUtil.unZip(filePath, destFile.getParent());
                    /**
                     *Start——文件解析入库
                     * 两个不同的listA和listB，将B中的与msgId与A中的入库
                     * */
                    List<CheckPathDetialDO> checkCollectDOS =  checkCollectService.selectCheckCollectCatchCheckPathDetia(settleDate,crdtParty);
                    parseFile(settleDate, fileInfDOPerson, destPath, checkCollectDOS);
                    /**
                     * End
                     * */
                } catch (Exception e) {
                    hasParseFile = true;
                    logger.warn("文件解析失败，日期：{}，文件名{}， 原因：{}",
                            fileInfDOPerson.getBatchId(), fileInfDOPerson.getFileName(), e.getMessage(), e);
                }
            }
        }
        else {
            logger.info("解析对账明细文件入库，日期：{}，没有需要解析的文件", settleDate);
        }
        //如果存在文件解析失败，抛出异常
        if (hasParseFile) {
            throw new Exception("解析文件失败");
        }
        /**
         * end
         * */
    }


    public void parseFile(String settleDate, DtlFileInfDOPerson dtlFileInfDOPerson, String destPath, List<CheckPathDetialDO> checkCollectDOS) throws Exception {
        logger.info("开始解析文件日期{}中的文件={}", dtlFileInfDOPerson.getBatchId(), destPath);
        //设置上限条数
        int limit = Integer.parseInt("1000");
        File file = new File(destPath);
        if (!file.exists()){
            logger.error("解析文件不存在");
            throw new Exception("File " + destPath + "路径上不存在解析文件");
        }

        /**
         * Start——开始解析文件
         * */
        List<CheckPathDetialDO> checkPathDetailDOS = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            //文件可能会很大，每次批量处理1000条入库
            String dateLine = null;
            //文件第一样为明细总数和明细总金额，需要抛弃
            boolean fisrtLine = false;
            //每次入库操作不超过1000条，用该变量做统计
            int count = 0;
            long fileDataCount = 0;
            while ((dateLine = reader.readLine()) != null) {
                //todo 丢弃第一行
                if (fisrtLine) {
                    fisrtLine = false;
                    continue;
                }

                //todo 增加空白行移除
                if (StringUtils.isEmpty(dateLine.trim())) {
                    continue;
                }
                // todo 文件的最后一行为<end> 结束标志，需要抛弃
                if (dateLine.trim().equals("<end>")) {
                    continue;
                }

                //处理行统计，日志体现
                fileDataCount++;
                //截取解压的文件中以 , 分开的数据，每隔一个记录到数组当中
                String[] data = dateLine.split("\\,", -1);
                //看数组元素长度如果长度 小于等于 所有条数据的最短元素长度的话则抛弃
                if (data.length <= 10) {
                continue;
                }
                /**
                 *start—— 截取文件数据导数组data[]
                 * 根据每行数据生成表对象
                 * */
                CheckPathDetialDO checkPathDetialDO = createCheckPathDetialDo(data, dtlFileInfDOPerson);
                checkPathDetialDO.setBatchId(settleDate);
                checkPathDetailDOS.add(checkPathDetialDO);
                /**
                 * end
                 * */
                count++;

                /**
                 *start—— 两个不同的listA和listB，将B中的msgId与A中相同的入库，以ListA为基准
                 * */
                //如果已经满(默认)1000， 可通过（limit配置）条数据，进行一次查库
                if (count == limit){
                    List<CheckPathDetialDO> resultList = getListBdataSampleListA(checkPathDetailDOS,checkCollectDOS);
                    int replaceSum = 0;
                    replaceSum = officialCheckPathDetailService.replaceCheckPathDtl(resultList);
                    if (replaceSum != count) {
                        logger.error("日期：{}，文件[{}]有数据入库失败", dtlFileInfDOPerson.getBatchId(), dtlFileInfDOPerson.getFileName());
                        throw new Exception("数据批量入库失败");
                    }
                    logger.debug("日期：{}，文件{}当前完成处理{}条数据", dtlFileInfDOPerson.getBatchId(), dtlFileInfDOPerson.getFileName(), fileDataCount);

                    //清空集合,准备下一次缓存入库操作
                    checkPathDetailDOS.clear();

                    //批次统计归零，一个批次最大如果可以1000条
                    count = 0;
                }
                logger.debug("解析文件{}，解析入库{}条", dtlFileInfDOPerson.getFileName(), fileDataCount);

                //避免最后一次统计无法入库
                if (!checkPathDetailDOS.isEmpty()) {
                    List<CheckPathDetialDO> resultList = getListBdataSampleListA(checkPathDetailDOS,checkCollectDOS);
                    int replaceSum = 0;
                    replaceSum = officialCheckPathDetailService.replaceCheckPathDtl(resultList);
                    logger.info("日期：{}，文件{}当前完成处理{}条数据", dtlFileInfDOPerson.getBatchId(), dtlFileInfDOPerson.getFileName(), fileDataCount);
                }
                /**
                 * end
                 * */
            }
        }
        /**
         * End
         * */
    }

    /**
     * 获取ListA与ListB中数据mesgid相同的的listB数据入库
     * */
    List<CheckPathDetialDO> getListBdataSampleListA(List<CheckPathDetialDO> checkPathDetailDOS, List<CheckPathDetialDO> checkCollectDOS) throws Exception {
        //解析完成后的list数据与officialCheckCollectDOS或CheckCollectDOS中的list数据进行msgId比对,相同的保存在(List<CheckPathDetialDO>)入库OFFICIAL_BATCH_CHECKPATHDTL / PAY_BATCH_CHECKPATHDTL
        List<CheckPathDetialDO> resultList = new ArrayList<>(); // 用于存放结果的List
        Set<String> msgIdSet = new HashSet<>(); // 用于存放officialCheckCollectDOS或CheckCollectDOS中所有msgId的Set

        // 先将officialCheckCollectDOS或CheckCollectDOS的所有msgId放入Set中
        for (CheckPathDetialDO checkCollectDOSdata : checkCollectDOS) {
            msgIdSet.add(checkCollectDOSdata.getMsgId());
        }

        // 遍历checkPathDetailDOS，如果msgId在Set中出现过，则将该数据放入resultList中
        for (CheckPathDetialDO checkPathDetailDOSdata : checkPathDetailDOS) {
            if (msgIdSet.contains(checkPathDetailDOSdata.getMsgId())) {
                resultList.add(checkPathDetailDOSdata);
            }
        }
        if(resultList.size()<1){
            throw new Exception("当前ListA没有对应记录");
        }
        return resultList;
    }


    private CheckPathDetialDO createCheckPathDetialDo(String[] data, DtlFileInfDOPerson fileInfDOPerson) {
        CheckPathDetialDO checkPathDetialDO = new CheckPathDetialDO();
        String workDate = data[14];//文件中交易时间  2022-06-06 15:56:06
        workDate = workDate.substring(0, 10).replaceAll("\\-", "");
        //业务日期,VARCHAR	8
        checkPathDetialDO.setWorkdate(workDate);

        //报文标识号	VARCHAR	35
        checkPathDetialDO.setMsgId(fileInfDOPerson.getMsgId());
        //	交易日期	VARCHAR	13
        checkPathDetialDO.setBatchId(fileInfDOPerson.getBatchId());
        //	文件名	VARCHAR	64
        checkPathDetialDO.setFileName(fileInfDOPerson.getFileName());

        // TODO: 2023/3/8 明细的报文标识号兴业对账文件没有该信息
        //	明细的报文标识号	VARCHAR	35
        checkPathDetialDO.setDtlMsgId(data[1]);
        //	发起机构	VARCHAR	14
        checkPathDetialDO.setInstgDrctPty(data[5]);

        //转换交易类型  兑出：C0C00001 兑回：RCC00001
        String MsgType = "";
        if ("C0C00001".equals(data[11])) {
            MsgType = "TO";
        } else if ("RCC00001".equals(data[11])) {
            MsgType = "TI";
        }
        //交易类型  兑出：C0C00001 兑回：RCC00001
        checkPathDetialDO.setMsgType(MsgType);
        //业务处理时间，文件的更新时间
        checkPathDetialDO.setDtlBizTime(data[14].substring(0,19));
        // checkPathDetialDO.setCcy(data[8]); //	货币代码	VARCHAR	3
        //存库前需要将人行元单位转成分单位
        //	金额	VARCHAR	18
        checkPathDetialDO.setAmount(data[13]);
        if ("C0C00001".equals(data[11])) {
            //付款账户账号(兑出交易返回)
            checkPathDetialDO.setPayerAccount(data[8]);
            //收款方钱包Id
            checkPathDetialDO.setPayeeWalletId(data[9]);
        } else if ("RCC00001".equals(data[11])) {
            //付款方钱包Id
            checkPathDetialDO.setPayerWalletId(data[8]);
            //收款人账号(兑回交易返回)
            checkPathDetialDO.setPayeeAccount(data[9]);
        }
        //付款机构编码	VARCHAR	14
        checkPathDetialDO.setDBITParty(data[6]);
        //	收款机构编码	VARCHAR	14
        checkPathDetialDO.setCRDTParty(fileInfDOPerson.getCrdtParty());

        //todo 业务状态 默认文件中都是成功
        //业务状态 默认文件中都是成功
        checkPathDetialDO.setDtlBizStatus(ProcessStsCdEnum.PR00.getCode());
        //初始化明细对账INIT
        checkPathDetialDO.setCheckStatus("INIT");
        checkPathDetialDO.setLastUpDate(DateUtil.getDefaultDate());
        checkPathDetialDO.setLastUpTime(DateUtil.getDefaultTime());
        return checkPathDetialDO;
    }

}
