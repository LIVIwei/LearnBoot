package com.example.justtest.service.impl;


import com.example.justtest.domain.CheckPathDO;
import com.example.justtest.domain.CheckPathDetialDO;
import com.example.justtest.domain.CheckResultDO;
import com.example.justtest.domain.OfficialCheckCollectDO;
import com.example.justtest.mapper.OfficialSettleCheckColectMapper;
import com.example.justtest.service.IOfficialCheckCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 对公对账明细采集表
 */
@Service
public class OfficialCheckCollectServiceImpl implements IOfficialCheckCollectService {

    @Autowired
    private OfficialSettleCheckColectMapper settleCheckColectMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public int insert(OfficialCheckCollectDO checkCollectDO) {
        return settleCheckColectMapper.insert(checkCollectDO);
    }

    /**
     * 批量插入数据
     *
     * @param list
     * @return
     */
    @Override
    public int insertByBatch(List<OfficialCheckCollectDO> list) {
        return settleCheckColectMapper.insertByBatch(list);
    }

    /**
     * 文件导入
     *
     * @param
     * @return
     */
    @Override
    public void loadFileByBatch(String fileName) {
        String sql = "load data infile '" + fileName + "' into table official_batch_checkcollect\r\n" +
                "        (PAYDATE, PAYSERNO, PAYTIME, COREACCTDATE, MSGTYPE, MSGID, BATCHID, PAYFLAG, INSTGDRCTPTY, DBITPARTY,\r\n" +
                "        PAYERWALLETID,\r\n" +
                "        PAYERACCOUNT, CRDTPARTY, PAYEENAME, PAYEEACCOUNT, PAYEEWALLETID, CCY, AMOUNT, OGNLMSGTYPE, OGNLMSGID,\r\n" +
                "        TRADESTATUS, CORESTATUS, PATHSTATUS, LASTUPDATE, LASTUPTIME)";
        jdbcTemplate.execute(sql);
    }

    @Override
    public List<OfficialCheckCollectDO> selectCheckCollect(String settleDate, String crdtParty) {
        return settleCheckColectMapper.selectCheckCollect(settleDate,crdtParty);
    }

    @Override
    public List<CheckPathDetialDO> selectCheckCollectCatchCheckPathDetia(String settleDate, String crdtParty) {
        return settleCheckColectMapper.selectCheckCollectCatchCheckPathDetia(settleDate,crdtParty);
    }

    @Override
    public List<CheckPathDO> selectCollectSumByMsgType(String settleDate, String crdtParty) {
        return settleCheckColectMapper.selectCollectSumByMsgType(settleDate,crdtParty);
    }

    @Override
    public List<CheckPathDO> selectCollectSumTotal(String settleDate, String crdtParty) {
        return settleCheckColectMapper.selectCollectSumTotal(settleDate,crdtParty);
    }

    /**
     * 查询金融交易登记表当前批次的数据数量
     *
    
     * 
     * @return
     */
    @Override
    public int selectPayTranstionDetailCount(String settleDate, String crdtParty) {
        return settleCheckColectMapper.selectPayTranstionDetailCount(settleDate,crdtParty);
    }

//    /**
//     * 查询金融交易登记表当前批次的数据
//     *
//
//     * 
//     * @param beginNum   给定值时，使用批量查询方式，如果不赋值则查询所有
//     * @param rowCount
//     * @return
//     */
//    public List<OfficialCheckCollectDO> selectPayTranstionDetails(String settleDate, String crdtParty, Long beginNum, Long rowCount) {
//        Map<String, Object> map = null;
//        if (beginNum != null && rowCount != null) {
//            map = ImmutableMap.of("batchId", batchId, "beginNum", beginNum, "rowCount", rowCount);
//        } else {
//            map = ImmutableMap.of("batchId", batchId);
//        }
//        return DBUtil.selectList(datasource, "settleCheckColectMapper.selectPayTranstionDetails", map);
//    }

    @Override
    public List<OfficialCheckCollectDO> selectPayTranstionDetails(String settleDate, String crdtParty, String fileName, Integer startrow, Integer endrow){
        List<OfficialCheckCollectDO> OfficialCheckCollectDOS = settleCheckColectMapper.intoFilePayTranstionDetails(settleDate,crdtParty, fileName, startrow, endrow);
        return OfficialCheckCollectDOS;
    }

    /**
     * 将查询金融交易登记表数据导入文件
     *
     * 
     * @param fileName
     * @return
     */
    @Override
    public int intoFilePayTranstionDetails(String settleDate, String crdtParty, String fileName, Integer startrow, Integer endrow) {
        List<OfficialCheckCollectDO> OfficialCheckCollectDOS = settleCheckColectMapper.intoFilePayTranstionDetails(settleDate,crdtParty, fileName, startrow, endrow);
        int check = 0;
        if (!OfficialCheckCollectDOS.isEmpty()) {
            check = 1;
        }
        return check;
    }


    /**
     * 查询通道对账明细表中对账异常的数据总数
     *
     * @param
     * 
     * @return
     */
    @Override
    public int selectPathDetailForNotMatchCount(String settleDate, String crdtParty) {
        return settleCheckColectMapper.selectPathDetailForNotMatchCount(settleDate,crdtParty);
    }

    /**
     * 查询通道对账明细表中对账异常的数据
     *
     * 
     * @return
     */
    @Override
    public List<CheckResultDO> selectPathDetailForNotMatch(String settleDate, String crdtParty, String dataType, Integer start, Integer end) {
        return settleCheckColectMapper.selectPathDetailForNotMatch(settleDate,crdtParty,dataType, start,end);
    }

    /**
     * 查询我行有，人行没有的交易数据总数
     *
     * @param
     * 
     * @return
     */
    @Override
    public int selectCollectWithPbocNotFoundCount(String settleDate, String crdtParty) {
        return settleCheckColectMapper.selectCollectWithPbocNotFoundCount(settleDate,crdtParty);
    }

    @Override
    public List<CheckResultDO> selectCollectWithPbocNotFound(String settleDate, String crdtParty, String dataType, Integer start, Integer end) {
        return settleCheckColectMapper.selectCollectWithPbocNotFound(settleDate,crdtParty, dataType, start,end);
    }

    /**
     * 查询金融交易登记表当前批次的数据
     *
    
     * 
     * @param msgIdList
     * @return
     */
    @Override
    public List<OfficialCheckCollectDO> selectPayTranstionDetailsByMsgId(String settleDate, String crdtParty, List<String> msgIdList) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("batchId", batchId);
//        map.put("list", msgIdList);
        return settleCheckColectMapper.selectPayTranstionDetailsByMsgId(settleDate,crdtParty,msgIdList);
    }

    @Override
    public int replaceIntoBatch(List<OfficialCheckCollectDO> list) {
        int count = 0;
        for(OfficialCheckCollectDO OfficialCheckCollectDO : list) {
            count += settleCheckColectMapper.replaceIntoBatch(OfficialCheckCollectDO);
        }
        return count;
    }

    /**
     * 查询通道对账明细表中对账结果数据
     *
     * @param
     * 
     * @return
     */
    @Override
    public List<CheckResultDO> selectPathDetailByMsgIdList(String settleDate, String crdtParty, String dataType, List<String> msgIdList) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("batchId", batchId);
//        map.put("list", msgIdList);
        return settleCheckColectMapper.selectPathDetailByMsgIdList(settleDate,crdtParty, dataType, msgIdList);
    }

    @Override
    public int deleteByBatchId(String settleDate, String crdtParty){
        return settleCheckColectMapper.deleteByBatchId(settleDate,crdtParty);
    }
}
