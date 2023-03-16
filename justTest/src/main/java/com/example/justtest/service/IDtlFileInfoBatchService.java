package com.example.justtest.service;


import com.example.justtest.domain.DtlFileInfDOPerson;

import java.util.List;

/**
 * 批次查询对账明细文件列表
 *
 * @author 
 * @date 2021/1/7
 */
public interface IDtlFileInfoBatchService {

    /**
     * 查找指定批次中的数据
     *
     * @return
     */
    List<DtlFileInfDOPerson> queryDtlFileInfoBatchIdStatus(String settleDate, String crdtParty);

}
