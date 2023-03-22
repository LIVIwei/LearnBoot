package com.example.justtest.mapper;

import com.example.justtest.domain.rcv.RcvMrchTradeReportDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商户交易统计交易统计信息报表Mapper接口
 * 
 * @author 
 * @date 2021-03-11
 */
@Mapper
public interface RcvMrchTradeReportDOMapper
{
    /**
     * 查询商户交易统计交易统计信息报表
     *
     * @param id 商户交易统计交易统计信息报表ID
     * @return 商户交易统计交易统计信息报表
     */

//    public RcvMrchTradeReportDO selectRcvMrchTradeReportDOById(String id);


    /**
     * 查询商户交易统计交易统计信息报表列表
     *
     * @param rcvMrchTradeReportDO 商户交易统计交易统计信息报表
     * @return 商户交易统计交易统计信息报表集合
     */

    public List<RcvMrchTradeReportDO> selectRcvMrchTradeReportDOList(RcvMrchTradeReportDO rcvMrchTradeReportDO);



    /**
     * 删除商户交易统计报表
     *
     */
    @Delete("delete from rcv_mrch_trade_report where report_date = #{reportDate}")
    int deleteRcvMrchTradeReportDOByBatchId(@Param("reportDate") String reportDate);

    /**
     * 新增商户交易统计报表
     *
     * @param rcvMrchTradeReportDO 商户交易统计报表
     * @return 结果
     */
    public int insertRcvMrchTradeReportDO(RcvMrchTradeReportDO rcvMrchTradeReportDO);
}
