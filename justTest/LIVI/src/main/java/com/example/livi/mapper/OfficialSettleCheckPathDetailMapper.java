package com.example.livi.mapper;


import com.example.livi.domain.CheckPathDetialDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @description: some desc
 * @author: zhangp
 * @date: 2021/3/11 17:35
 */

@Mapper
public interface OfficialSettleCheckPathDetailMapper {

     int insert(CheckPathDetialDO checkPathDetialDO);

     List<CheckPathDetialDO> selectPathDetail(@Param("workdate") String workdate, @Param("crdtParty") String crdtParty, @Param("checkstatus") String checkstatus);


     List<CheckPathDetialDO> selectPathDetailCore(@Param("startworkdate") String startworkdate, @Param("endworkdate") String endworkdate, @Param("msgId") String msgId, @Param("crdtParty") String crdtParty, @Param("checkstatus") String checkstatus, @Param("coreserno") String coreserno);


     int insertByBatch(List<CheckPathDetialDO> checkPathDetialDOS);

     int replace(List<CheckPathDetialDO> checkPathDetialDOS);
    /**
     * 统计当前批次两方都存在的情况下需要对账的总数
     * @param workdate

     * @return
     */
     int selectCheckDetailCount(@Param("workdate") String workdate, @Param("crdtParty") String crdtParty);

    /**
     * 对人行的交易明细和我行的交易明细进行状态比对，然后更新结果状态, 不限制更新的条数
     */
     int updateCheckStatusForMsgMatchWithoutLimit(@Param("workdate") String workdate, @Param("crdtParty") String crdtParty, @Param("list") List<String> msgIdList);
    /**
     * 对人行的交易明细和我行的交易明细进行状态比对，然后更新结果状态, 限制更新的条数
     * @param updateNumber 每次更新的记录数
     */

     int updateCheckStatusForMsgMatchWithLimit(@Param("workdate") String workdate, @Param("crdtParty") String crdtParty, @Param("updateNumber") Integer updateNumber);
    /**
     * 使用主键更新对账后的状态
     *
     * @param msgId
     * @param dtlMsgId
     * @param checkStatus
     * @return
     */
     int updateStatus(@Param("msgId") String msgId, @Param("lastUpDate") String date, @Param("lastUpTime") String time, @Param("dtlMsgId") String dtlMsgId, @Param("checkStatus") String checkStatus);

    /**
     * 查找当前日期下，给定的批次号中人行有数据，但我行没有的明细数据的总数
     * @param workdate

     * @return
     */
     int selectPathDetailWhitCgbNotFoundCount(@Param("workdate") String workdate, @Param("crdtParty") String crdtParty);
    /**
     * 查找当前日期下，给定的批次号中人行有数据，但我行没有的明细数据
     *
     * @param workdate

     * @return
     */
     List<CheckPathDetialDO> selectPathDetailWhitCgbNotFound(@Param("workdate") String workdate, @Param("crdtParty") String crdtParty, @Param("start") Integer start, @Param("end") Integer end);


    CheckPathDetialDO querySingle(@Param("msgId") String msgId, @Param("dtlmsgId") String dtlmsgId);

    @Delete("delete from OFFICIAL_BATCH_CHECKPATHDTL where workdate = #{workdate} and crdtparty = #{crdtParty}")
    int deleteByBatchId(@Param("workdate") String settleDate, @Param("crdtParty") String crdtParty);
    /**
     * 删除交易记录中钱包ID不是对公钱包的记录
     * @param batchId
     * @param crdtParty
     * @return
     */
    int deleteWalletNotExists(@Param("batchId") String batchId, @Param("crdtParty") String crdtParty);
}
