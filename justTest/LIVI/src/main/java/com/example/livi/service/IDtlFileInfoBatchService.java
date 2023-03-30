package com.example.livi.service;


import com.example.livi.domain.DtlFileInfDOPerson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 批次查询对账明细文件列表
 *
 * @author 
 * @date 2021/1/7
 */
@Mapper
public interface IDtlFileInfoBatchService {

    /**
     * 查找指定批次中的数据
     *
     * @return
     */
    List<DtlFileInfDOPerson> queryDtlFileInfoBatchIdStatus(String settleDate, String crdtParty);

}
