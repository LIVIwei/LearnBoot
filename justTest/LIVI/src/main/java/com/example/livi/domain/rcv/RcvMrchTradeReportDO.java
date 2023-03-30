package com.example.livi.domain.rcv;

import com.example.livi.annotation.Excel;
import com.example.livi.web.domain.BaseEntity;
import lombok.Data;

/**
 * 商户交易统计报表对象 pay_batch_finance_report
 *
 * @author
 * @date 2021-03-11
 */
@Data
public class RcvMrchTradeReportDO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 报表日期
     */
    @Excel(name = "报表日期")
    private String reportDate;

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    private String mrchId;

    /**
     * 交易总笔数
     */
    @Excel(name = "交易总笔数")
    private String txnNumber;

    /**
     * 交易总金额
     */
    @Excel(name = "交易总金额（元）")
    private String txnAmount;

    /**
     * 交易成功笔数
     */
    @Excel(name = "交易成功笔数")
    private String txnSuccessNumber;

    /**
     * 交易成功金额
     */
    @Excel(name = "交易成功金额（元）")
    private String txnSuccessAmount;

    /**
     * 退款总笔数
     */
    @Excel(name = "退款总笔数")
    private String refundNumber;

    /**
     * 退款总金额
     */
    @Excel(name = "退款总金额（元）")
    private String refundAmount;

    /**
     * 运营机构
     */
    @Excel(name = "运营机构", readConverterExp = "CCB=建设银行,BOC=中国银行,COMM=交通银行, ICBC=工商银行")
    private String sysType;

    /**
     * 退款成功笔数
     */
    private String refundSuccessNumber;

    /**
     * 订单金额
     * */
//    private String ordrAmt;

    //查询条件
    /**
     * 报表开始日期
     */
    private String beginDate;

    /**
     * 报表结束日期
     */
    private String endDate;

}
