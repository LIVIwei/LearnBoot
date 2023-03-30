package com.example.livi.mapper;

import com.example.livi.domain.DtlFileInfDOPerson;
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
