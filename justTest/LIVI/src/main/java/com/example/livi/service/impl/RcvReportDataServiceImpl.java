package com.example.livi.service.impl;

import com.example.livi.domain.rcv.RcvMrchTradeReportDO;
import com.example.livi.mapper.RcvMrchTradeReportDOMapper;
import com.example.livi.mapper.RcvOrderMapper;
import com.example.livi.mapper.RcvRefundOrderMapper;
import com.example.livi.service.IRCVReportDataService;
import com.example.livi.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by yangjld on
 */
@Service
public class RcvReportDataServiceImpl implements IRCVReportDataService {

    @Autowired
    private RcvRefundOrderMapper rcvRefundOrderMapper;
    @Autowired
    private RcvOrderMapper rcvOrderMapper;

    @Autowired
    private RcvMrchTradeReportDOMapper rcvMrchTradeReportDOMapper;


    @Override
    public void rcvmrchtradereport(String reportDate) {
        rcvMrchTradeReportInfo(reportDate);
    }

    /**
     * 商户交易统计报表
     * @param reportDate
     */
    private void rcvMrchTradeReportInfo(String reportDate) {
        //商户交易统计实体类
        RcvMrchTradeReportDO rcvMrchTradeReportDO = new RcvMrchTradeReportDO();
        //删除原有日期数据
        rcvMrchTradeReportDOMapper.deleteRcvMrchTradeReportDOByBatchId(reportDate);

        //获取订单表相关信息
        //根据报表日期获取交易总笔数，交易总金额，交易成功笔数，交易成功金额，商户号，报表日期
        List<RcvMrchTradeReportDO> rcvOrderInfoList = rcvOrderMapper.selectRcvOrderinfoByReportDate(reportDate);
        //获取退款表相关信息
        //根据报表日期获取退款总笔数，退款总金额，商户号，报表日期
        List<RcvMrchTradeReportDO> rcvRefundOrderInfoList = rcvRefundOrderMapper.selectRcvRefundOrderinfoByReportDate(reportDate);
        HashMap<String, List<RcvMrchTradeReportDO>> mrchidHashMap = new HashMap<>();//hashMap的key不能重复
        //以商户号，报表日期，运营机构编号，作为key进行对比
        for (int i= 0; i<rcvOrderInfoList.size();i++){
            String mrchId = rcvOrderInfoList.get(i).getMrchId();
            String sysType = rcvOrderInfoList.get(i).getSysType();
            String orderReportDate = rcvOrderInfoList.get(i).getReportDate();
            String key = orderReportDate + "-" + mrchId + ":" + sysType;
            List<RcvMrchTradeReportDO> list = mrchidHashMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                mrchidHashMap.put(key, list);
            }
            list.add(rcvOrderInfoList.get(i));
        }
        for (int j= 0; j<rcvRefundOrderInfoList.size();j++){
            String mrchId = rcvRefundOrderInfoList.get(j).getMrchId();
            String sysType = rcvRefundOrderInfoList.get(j).getSysType();
            String refundOrderReportDate = rcvRefundOrderInfoList.get(j).getReportDate();
            String key = refundOrderReportDate + "-" + mrchId + ":" + sysType;
            List<RcvMrchTradeReportDO> list = mrchidHashMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                mrchidHashMap.put(key, list);
            }
            list.add(rcvRefundOrderInfoList.get(j));
        }
        //效果：
        // 1、key：商户号，日期，运营机构；value：交易总笔数，交易总金额，交易成功笔数，交易成功金额，商户号，报表日期，退款总笔数，退款总金额，运营机构
        // 2、key：商户号，日期，运营机构；value：交易总笔数，交易总金额，交易成功笔数，交易成功金额，商户号，报表日期，数据库设默认值退款总笔数，退款总金额为0，运营机构
        // 3、不会存在这种情况，退款有的话就一定会有交易
        //把mrchidHashMap的数据放到RcvMrchTradeReportDO实体对应的RCV_MRCH_TRADE_REPORT表中
        for (Map.Entry<String, List<RcvMrchTradeReportDO>> tradeReport : mrchidHashMap.entrySet()){
            List<RcvMrchTradeReportDO> list = tradeReport.getValue();
            if (list != null && !list.isEmpty()) {
                RcvMrchTradeReportDO mrchTradeReportDO = new RcvMrchTradeReportDO();
                int orderTotalCount = 0;
                int orderTotalAmt = 0;
                int orderSuccCount = 0;
                int orderSuccAmt = 0;
                int refundCount = 0;
                int refundAmt = 0;
                int value = 0;
                int idx = tradeReport.getKey().indexOf("-");
                int idx0 = tradeReport.getKey().indexOf(":");
                String date = tradeReport.getKey().substring(0, idx);
                String mrchId = tradeReport.getKey().substring(idx+1,idx0);
                String sysType = tradeReport.getKey().substring(idx0+1);
                for (RcvMrchTradeReportDO tradeReportDO : list) {
                    value = toNumber(tradeReportDO.getTxnNumber());
                    orderTotalCount += value;
                    value = toNumber(tradeReportDO.getTxnAmount());
                    orderTotalAmt += value;
                    value = toNumber(tradeReportDO.getTxnSuccessNumber());
                    orderSuccCount += value;
                    value = toNumber(tradeReportDO.getTxnSuccessAmount());
                    orderSuccAmt += value;
                    value = toNumber(tradeReportDO.getRefundNumber());
                    refundCount += value;
                    value = toNumber(tradeReportDO.getRefundAmount());
                    refundAmt += value;
                }
                mrchTradeReportDO.setReportDate(date);
                mrchTradeReportDO.setMrchId(mrchId);
                mrchTradeReportDO.setSysType(sysType);
                mrchTradeReportDO.setTxnNumber(String.valueOf(orderTotalCount));
                mrchTradeReportDO.setTxnAmount(String.valueOf(orderTotalAmt));
                mrchTradeReportDO.setTxnSuccessNumber(String.valueOf(orderSuccCount));
                mrchTradeReportDO.setTxnSuccessAmount(String.valueOf(orderSuccAmt));
                mrchTradeReportDO.setRefundNumber(String.valueOf(refundCount));
                mrchTradeReportDO.setRefundAmount(String.valueOf(refundAmt));
                rcvMrchTradeReportDOMapper.insertRcvMrchTradeReportDO(mrchTradeReportDO);
            }
        }
    }

    private int toNumber(String txt) {
        if (StringUtils.isEmpty(txt)) {
            return 0;
        }
        return Integer.parseInt(txt);
    }
}
