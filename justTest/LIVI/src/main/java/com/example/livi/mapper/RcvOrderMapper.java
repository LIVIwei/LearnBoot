package com.example.livi.mapper;


import com.example.livi.domain.rcv.RcvMrchTradeReportDO;
import com.example.livi.domain.rcv.RcvOrder;
import com.example.livi.entity.RcvOrderCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RcvOrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(RcvOrder record);

    int insertSelective(RcvOrder record);

    RcvOrder selectByPrimaryKey(String orderId);

    List<RcvOrder> selectList(RcvOrder record);

    int updateByPrimaryKeySelective(RcvOrder record);

    int updateByPrimaryKey(RcvOrder record);

    List<RcvOrderCustom> selectListWithRefundSts(RcvOrder record);

    RcvOrder selectByOrderNo(String orderNo);

    int updateByOrderNoSelective(RcvOrder rcvOrder);

    int updateByMerOrderNoSelective(RcvOrder rcvOrder);

    List<RcvOrder> selectRecord(@Param("orderNo") String orderNo,
                                @Param("rcvOrderId") String rcvOrderId,
                                @Param("mrchId") String mrchId);

    /**
     * 查询订单信息报表
     *
     * @param id 订单信息报表ID
     * @return 订单信息报表
     */
    public RcvOrder selectRcvOrderInfoById(String id);

    /**
     * 查询订单信息报表列表
     *
     * @param rcvOrder 订单信息报表
     * @return 订单信息报表集合
     */
    public List<RcvOrder> selectRcvOrderInfoDOList(RcvOrder rcvOrder);

//    /**
//     * 订单信息报表汇总列表
//     *
//     * @param rcvOrder 订单信息报表汇总
//     * @return 订单信息报表集合
//     */
//    public List<RcvOrder> selectRcvOrderReportList(RcvOrder rcvOrder);

    /**
     * 查询商户id列表
     *
     * @param rcvOrder
     */
    public List<RcvMrchTradeReportDO> selectRcvOrderMrchIdList(RcvOrder rcvOrder);

    /**
     * 根据reportDate来进行获取信息
     * @param reportDate
     */

    public List<RcvMrchTradeReportDO> selectRcvOrderinfoByReportDate(String reportDate);
//    public List<RcvOrder> selectRcvOrderinfoByReportDate(String reportDate);

}
