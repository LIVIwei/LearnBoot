package com.example.justtest.service.impl;

import com.example.justtest.domain.CheckPathDetialDO;
import com.example.justtest.domain.DtlFileInfDOPerson;
import com.example.justtest.service.IDtlFileInfoBatchService;
import com.example.justtest.service.IDtlFileParseCibService;
import com.example.justtest.service.IOfficialCheckCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LIVI
 * @Time: 2023/03/16  17:35
 * @Description: 解析zip文件内容入库，两个不同的listA和listB，将B中的与msgId与A中的入库
 */
@Service
public class DtlFileParseServiceImpl implements IDtlFileParseCibService {
    @Autowired
    private IOfficialCheckCollectService checkCollectService;
    @Autowired
    private IDtlFileInfoBatchService dtlFileInfoBatchService;

    @Override
    public void parse(String settleDate, String crdtParty) throws Exception {
        /**
         *从数据库中获取需要解析的文件的路径
         * */
        List<DtlFileInfDOPerson> fileInfDOPersonList = dtlFileInfoBatchService.queryDtlFileInfoBatchIdStatus(settleDate, crdtParty);
        //定义变量标识是否存在解析失败的文件
        boolean hasParseFile = false;
        /**
         * start——开始解析文件
         * */
        for (DtlFileInfDOPerson fileInfDOPerson : fileInfDOPersonList) {

        }
        /**
         * end
         * */

        List<CheckPathDetialDO> checkCollectDOS =  checkCollectService.selectCheckCollectCatchCheckPathDetia(settleDate,crdtParty);
        // parseFile(settleDate, fileInfDOPerson, destPath, dataType, checkCollectDOS);
    }
}
