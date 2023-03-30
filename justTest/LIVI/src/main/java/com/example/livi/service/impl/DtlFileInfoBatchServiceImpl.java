package com.example.livi.service.impl;

import com.example.livi.domain.DtlFileInfDOPerson;
import com.example.livi.mapper.SettledtlFileInfoBatchMapper;
import com.example.livi.service.IDtlFileInfoBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 批量对账文件组件
 *
 * @author 
 * @date 2021/1/7
 */
@Service
public class DtlFileInfoBatchServiceImpl implements IDtlFileInfoBatchService {

    @Autowired
    private SettledtlFileInfoBatchMapper settledtlFileInfoBatchMapper;
    @Override
    public List<DtlFileInfDOPerson> queryDtlFileInfoBatchIdStatus(String batchId, String crdtParty) {
        return settledtlFileInfoBatchMapper.queryDtlFileInfoByBatchIdStatus(batchId,crdtParty);
    }
}
