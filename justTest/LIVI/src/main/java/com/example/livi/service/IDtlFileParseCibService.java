package com.example.livi.service;


import java.io.IOException;

/**
 * 兴业对账文件解压解析
 *
 * @author 
 * @date 2021/1/8
 */
public interface IDtlFileParseCibService {

    /**
     * 解析指定批次的文件
     */
    void parse(String settleDate, String crdtParty) throws Exception;

    /**
     * 解析明细对账文件，将文件数据入库
     * @param dtlFileInfDOPerson
     * @param file
     * @throws IOException
     */
    // void parseFile(String settleDate, DtlFileInfDOPerson dtlFileInfDOPerson, String file, String dataType , List<CheckPathDetialDO> checkCollectDOS) throws IOException;


}
