package com.example.justtest.mapper;


import com.example.justtest.domain.rcv.RcvMrchTradeReportDO;
import com.example.justtest.domain.rcv.RcvRefundOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RcvRefundOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(RcvRefundOrder record);

    int insertSelective(RcvRefundOrder record);

    RcvRefundOrder selectByPrimaryKey(String id);

    List<RcvRefundOrder> selectList(RcvRefundOrder record);

    int updateByPrimaryKeySelective(RcvRefundOrder record);
    int updateByPrimaryKeySelective1(RcvRefundOrder record);

    int updateByPrimaryKey(RcvRefundOrder record);

    RcvRefundOrder selectByRefundId(String refundId);

    List<RcvRefundOrder> selectByOrdrNo(String orderNo);

    int updateByOrderNo(RcvRefundOrder record);

    List<RcvRefundOrder> selectRecord(@Param("mrchId") String mrchId,
                                      @Param("rcvOrderId") String rcvOrderId);

    List<RcvRefundOrder> selectByOrigMchtOrderId(@Param("origMchtOrderNo") String origMchtOrderNo);

    RcvRefundOrder selectRefundSumByOrigMchtOrderId(@Param("origMchtOrderNo") String origMchtOrderNo);

    /**
     * 查询退款信息报表
     *
     * @param id 退款信息报表ID
     * @return 退款信息报表
     */
    public RcvRefundOrder selectRcvRefoudOrderInfoById(String id);

    /**
     * 查询退款信息报表列表
     *
     * @param rcvRefundOrder 退款信息报表
     * @return 退款信息报表集合
     */
    public List<RcvRefundOrder> selectRcvRefoudOrderInfoDOList(RcvRefundOrder rcvRefundOrder);

    /**
     * 查询商户id列表
     *
     * @param rcvRefundOrder
     */
    public List<RcvMrchTradeReportDO> selectRcvOrderMrchIdList(RcvRefundOrder rcvRefundOrder);

    /**
     * 根据reportDate来进行获取信息
     * @param reportDate
     */
    public List<RcvMrchTradeReportDO> selectRcvRefundOrderinfoByReportDate(String reportDate);
}
