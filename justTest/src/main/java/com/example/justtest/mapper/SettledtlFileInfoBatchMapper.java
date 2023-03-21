package com.example.justtest.mapper;

import com.example.justtest.domain.DtlFileInfDOPerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: some desc
 * @author:
 * @date:
 */

@Mapper

public interface SettledtlFileInfoBatchMapper {
     List<DtlFileInfDOPerson> queryDtlFileInfoByBatchIdStatus(@Param("batchId")String batchId, @Param("crdtParty")String crdtParty);
}
