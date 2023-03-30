package com.example.livi.domain.rcv;

import com.example.livi.annotation.Excel;

import java.io.Serializable;

public class RcvOrder implements Serializable {
    /**
     * 交易日期
     */
    @Excel(name = "交易日期")
    private String txnDt;

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    private String mrchId;

    /**
     * 订单Id
     */
    @Excel(name = "商户订单号")
    private String orderId;

    /**
     * 支付订单号
     */
    @Excel(name = "支付订单号")
    private String orderNo;

    /**
     * 内部商户号
     */
    @Excel(name = "外部商户号")
    private String insideMrchId;

    /**
     *  交易类型(QT04:商户动态码, QT00:商户主扫 )
     */
    @Excel(name = "交易类型 ",readConverterExp = "QT04=商户动态码,QT00=商户主扫,QT03=商户静态码")
    private String txnType;

    /**
     * 终端号
     */
    @Excel(name = "终端号 ")
    private String posId;

    /**
     * 订单金额
     */
    @Excel(name = "订单金额（元）")
    private String ordrAmt;

    /**
     * 实际支付金额
     */
    @Excel(name = "实际支付金额（元）")
    private String txnAmt;

    /**
     * 交易状态
     */
    @Excel(name = "交易状态",readConverterExp = "N=交易成功,E=交易失败,S=交易未决")
    private String txnStatus;

    /**
     * 订单状态
     */
    @Excel(name = "订单状态",readConverterExp = "01=订单创建,02=用户支付中,03=已关闭,04=部分退款,05=全部退款,06=交易成功")
    private String tradeState;

    /**
     * 系统类型，CCB:建设银行, BOC：中国银行, COMM：交通银行, ICBC: 工商银行
     */
    @Excel(name = "运营机构", readConverterExp = "CCB=建设银行,BOC=中国银行,COMM=交通银行, ICBC=工商银行")
    private String sysType;

    /**
     * 创建时间
     */
//    @Excel(name = "创建时间")
    private String createDatetime;

    /**
     * 修改时间
     */
//    @Excel(name = "修改时间")
    private String modifyDatetime;

    /**
     * 交易时间
     */
//    @Excel(name = "交易时间")
    private String txnTm;

    /**
     * 币种，默认CNY
     */
//    @Excel(name = "币种")
    private String currency;

//    @Excel(name = "付款钱包ID")
    private String payWalletId; //付款方钱包 id

//    @Excel(name = "支付完成时间")
    private String payTime; //支付完成时间

    /**
     * 订单状态描述
     */
    private String tradeStateDsc;

    /**
     * 柜台号
     */
    private String cntrprtId;

    /**
     * 商品名称
     */
    private String cmdtyNm;

    /**
     * 订单详情
     */
    private String ordrDtl;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 交易描述
     */
    private String txnItmDsc;
    
    /**
     * 二维码失效时间
     */
    private String invalidDate;

    /**
     * 对账备注
     */
    private String checkRemark;



    /**************************/
    /**
     * 渠道
     */
    private String channelFlag;

    /**
     * 商户系统内部订单号
     */
    private String merOrderNo;

    /**
     * 现金支付币种，默认CNY
     */
    private String cashCurrency;

    /**
     * 支付人信息，目前为付款方钱包号
     */
    private String payerInfo;

/**************************************/

    /**
     * rcv_order
     */
    private static final long serialVersionUID = 1L;

    //查询条件
    /** 报表开始日期 */
    private String beginDate;

    /** 报表结束日期 */
    private String endDate;

    /** 最大金额 */
    private String maxOrdrAmt;

    /** 最小金额 */
    private String minOrdrAmt;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMaxOrdrAmt() {
        return maxOrdrAmt;
    }

    public void setMaxOrdrAmt(String maxOrdrAmt) {
        this.maxOrdrAmt = maxOrdrAmt;
    }

    public String getMinOrdrAmt() {
        return minOrdrAmt;
    }

    public void setMinOrdrAmt(String minOrdrAmt) {
        this.minOrdrAmt = minOrdrAmt;
    }

    public String getTradeStateDsc() {
        return tradeStateDsc;
    }

    public void setTradeStateDsc(String tradeStateDsc) {
        this.tradeStateDsc = tradeStateDsc;
    }

    public String getSysType() {
		return sysType;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}


    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCashCurrency() {
        return cashCurrency;
    }

    public void setCashCurrency(String cashCurrency) {
        this.cashCurrency = cashCurrency;
    }

    public String getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(String payerInfo) {
        this.payerInfo = payerInfo;
    }


    public String getChannelFlag() {
        return channelFlag;
    }

    public void setChannelFlag(String channelFlag) {
        this.channelFlag = channelFlag;
    }

    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    public String getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }

    /**
     * 订单Id
     * @return order_id 订单Id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单Id
     * @param orderId 订单Id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 商户号
     * @return mrch_id 商户号
     */
    public String getMrchId() {
        return mrchId;
    }

    /**
     * 商户号
     * @param mrchId 商户号
     */
    public void setMrchId(String mrchId) {
        this.mrchId = mrchId == null ? null : mrchId.trim();
    }

    /**
     * 内部商户号
     * @return inside_mrch_id 内部商户号
     */
    public String getInsideMrchId() {
        return insideMrchId;
    }

    /**
     * 内部商户号
     * @param insideMrchId 内部商户号
     */
    public void setInsideMrchId(String insideMrchId) {
        this.insideMrchId = insideMrchId == null ? null : insideMrchId.trim();
    }

    /**
     *  交易类型(QT04:商户动态码, QT00:商户主扫 )
     * @return txn_type  交易类型(QT04:商户动态码, QT00:商户主扫 )
     */
    public String getTxnType() {
        return txnType;
    }

    /**
     *  交易类型(QT04:商户动态码, QT00:商户主扫 )
     * @param txnType  交易类型(QT04:商户动态码, QT00:商户主扫 )
     */
    public void setTxnType(String txnType) {
        this.txnType = txnType == null ? null : txnType.trim();
    }

    /**
     * 柜台号
     * @return cntrprt_id 柜台号
     */
    public String getCntrprtId() {
        return cntrprtId;
    }

    /**
     * 柜台号
     * @param cntrprtId 柜台号
     */
    public void setCntrprtId(String cntrprtId) {
        this.cntrprtId = cntrprtId == null ? null : cntrprtId.trim();
    }

    /**
     * 终端号
     * @return pos_id 终端号
     */
    public String getPosId() {
        return posId;
    }

    /**
     * 终端号
     * @param posId 终端号
     */
    public void setPosId(String posId) {
        this.posId = posId == null ? null : posId.trim();
    }

    /**
     * 订单金额
     * @return ordr_amt 订单金额
     */
    public String getOrdrAmt() {
        return ordrAmt;
    }

    /**
     * 订单金额
     * @param ordrAmt 订单金额
     */
    public void setOrdrAmt(String ordrAmt) {
        this.ordrAmt = ordrAmt;
    }

    /**
     * 商品名称
     * @return cmdty_nm 商品名称
     */
    public String getCmdtyNm() {
        return cmdtyNm;
    }

    /**
     * 商品名称
     * @param cmdtyNm 商品名称
     */
    public void setCmdtyNm(String cmdtyNm) {
        this.cmdtyNm = cmdtyNm == null ? null : cmdtyNm.trim();
    }

    /**
     * 订单详情
     * @return ordr_dtl 订单详情
     */
    public String getOrdrDtl() {
        return ordrDtl;
    }

    /**
     * 订单详情
     * @param ordrDtl 订单详情
     */
    public void setOrdrDtl(String ordrDtl) {
        this.ordrDtl = ordrDtl == null ? null : ordrDtl.trim();
    }

    /**
     * 二维码
     * @return qrcode 二维码
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 二维码
     * @param qrcode 二维码
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    /**
     * 交易状态
     * @return txn_status 交易状态
     */
    public String getTxnStatus() {
        return txnStatus;
    }

    /**
     * 交易状态
     * @param txnStatus 交易状态
     */
    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus == null ? null : txnStatus.trim();
    }

    /**
     * 交易描述
     * @return txn_itm_dsc 交易描述
     */
    public String getTxnItmDsc() {
        return txnItmDsc;
    }

    /**
     * 交易描述
     * @param txnItmDsc 交易描述
     */
    public void setTxnItmDsc(String txnItmDsc) {
        this.txnItmDsc = txnItmDsc == null ? null : txnItmDsc.trim();
    }

    /**
     * 创建时间
     * @return create_datetime 创建时间
     */
    public String getCreateDatetime() {
        return createDatetime;
    }

    /**
     * 创建时间
     * @param createDatetime 创建时间
     */
    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime == null ? null : createDatetime.trim();
    }

    /**
     * 修改时间
     * @return modify_datetime 修改时间
     */
    public String getModifyDatetime() {
        return modifyDatetime;
    }

    /**
     * 修改时间
     * @param modifyDatetime 修改时间
     */
    public void setModifyDatetime(String modifyDatetime) {
        this.modifyDatetime = modifyDatetime == null ? null : modifyDatetime.trim();
    }

    /**
     * 交易日期
     * @return txn_dt 交易日期
     */
    public String getTxnDt() {
        return txnDt;
    }

    /**
     * 交易日期
     * @param txnDt 交易日期
     */
    public void setTxnDt(String txnDt) {
        this.txnDt = txnDt == null ? null : txnDt.trim();
    }

    /**
     * 交易时间
     * @return txn_tm 交易时间
     */
    public String getTxnTm() {
        return txnTm;
    }

    /**
     * 交易时间
     * @param txnTm 交易时间
     */

    public void setTxnTm(String txnTm) {
        this.txnTm = txnTm == null ? null : txnTm.trim();
    }
    
    public String getInvalidDate() {
		return invalidDate;
	}

	public void setInvalidDate(String invalidDate) {
		this.invalidDate = invalidDate;
	}

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayWalletId() {
        return payWalletId;
    }

    public void setPayWalletId(String payWalletId) {
        this.payWalletId = payWalletId;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "RcvOrder{" +
                "txnDt='" + txnDt + '\'' +
                ", mrchId='" + mrchId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", insideMrchId='" + insideMrchId + '\'' +
                ", txnType='" + txnType + '\'' +
                ", posId='" + posId + '\'' +
                ", ordrAmt='" + ordrAmt + '\'' +
                ", txnAmt='" + txnAmt + '\'' +
                ", txnStatus='" + txnStatus + '\'' +
                ", tradeState='" + tradeState + '\'' +
                ", sysType='" + sysType + '\'' +
                ", createDatetime='" + createDatetime + '\'' +
                ", modifyDatetime='" + modifyDatetime + '\'' +
                ", txnTm='" + txnTm + '\'' +
                ", currency='" + currency + '\'' +
                ", payWalletId='" + payWalletId + '\'' +
                ", payTime='" + payTime + '\'' +
                ", tradeStateDsc='" + tradeStateDsc + '\'' +
                ", cntrprtId='" + cntrprtId + '\'' +
                ", cmdtyNm='" + cmdtyNm + '\'' +
                ", ordrDtl='" + ordrDtl + '\'' +
                ", qrcode='" + qrcode + '\'' +
                ", txnItmDsc='" + txnItmDsc + '\'' +
                ", invalidDate='" + invalidDate + '\'' +
                ", checkRemark='" + checkRemark + '\'' +
                ", channelFlag='" + channelFlag + '\'' +
                ", merOrderNo='" + merOrderNo + '\'' +
                ", cashCurrency='" + cashCurrency + '\'' +
                ", payerInfo='" + payerInfo + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", maxOrdrAmt='" + maxOrdrAmt + '\'' +
                ", minOrdrAmt='" + minOrdrAmt + '\'' +
                '}';
    }
}