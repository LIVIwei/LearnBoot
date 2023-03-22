package com.example.justtest.domain.rcv;

import com.example.justtest.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class RcvRefundOrder implements Serializable {
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
     * 内部商户号
     */
    @Excel(name = "外部商户号")
    private String insideMrchId;

    /**
     * 交易状态
     */
    @Excel(name = "交易状态",readConverterExp = "N=交易成功,E=交易失败,S=交易未决")
    private String txnStatus;

    /**
     * 交易功能号(01：消费撤销, 02：退货)
     */
    @Excel(name = "交易功能号",readConverterExp = "01=消费撤销,02=退货")
    private String txnFcnNo;

    /**
     * 原商户订单号
     */
    @Excel(name = "原商户订单号")
    private String originOrdrId;

    /**
     * 退款订单号
     */
    @Excel(name = "退款订单号")
    private String refundOrdrId;

    /**
     * 订单金额
     */
    @Excel(name = "订单金额（元）")
    private String ordrAmt;

    /**
     * 退款金额
     */
    @Excel(name = "退款金额（元）")
    private String ahnTxnAmt;

    /**
     * 累计退款金额
     */
    @Excel(name = "累计退款金额（元）")
    private String alrdRfndAmt;

    /**
     * 原订单号
     * */
    @Excel(name = "原支付订单号")
    private String ordrNo;

    /**
     * 系统类型，CCB:建设银行, BOC：中国银行, COMM：交通银行, ICBC: 工商银行
     */
    @Excel(name = "运营机构", readConverterExp = "CCB=建设银行,BOC=中国银行,COMM=交通银行, ICBC=工商银行")
    private String sysType;

    /**
     * 订单状态
     * */
    @Excel(name = "订单状态",readConverterExp = "01=订单创建,02=用户支付中,03=已关闭,04=部分退款,05=全部退款,06=交易成功")
    private String tradeState;

    /**
     * 退款id
     */
//    @Excel(name = "退款id")
    private String id;

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
     * 退款项描述
     */
    private String txnItmDsc;

    /**
     * rcv_refund_order
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单状态描述
     * */
    private String tradeStateDsc;

    //查询条件
    /** 报表开始日期 */
    private String beginDate;

    /** 报表结束日期 */
    private String endDate;

    /** 最大金额 */
    private String maxAhnTxnAmt;

    /** 最小金额 */
    private String minAhnTxnAmt;

    /**
     * 字段别名，仅记录信息不作处理
    * */
    private String balance;


    public String getTradeStateDsc() {
        return tradeStateDsc;
    }

    public void setTradeStateDsc(String tradeStateDsc) {
        this.tradeStateDsc = tradeStateDsc;
    }

    public String getOrdrNo() {
        return ordrNo;
    }

    public void setOrdrNo(String ordrNo) {
        this.ordrNo = ordrNo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getOrdrAmt() {
        return ordrAmt;
    }

    public void setOrdrAmt(String ordrAmt) {
        this.ordrAmt = ordrAmt;
    }

    public String getSysType() {
		return sysType;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

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

    public String getMaxAhnTxnAmt() {
        return maxAhnTxnAmt;
    }

    public void setMaxAhnTxnAmt(String maxAhnTxnAmt) {
        this.maxAhnTxnAmt = maxAhnTxnAmt;
    }

    public String getMinAhnTxnAmt() {
        return minAhnTxnAmt;
    }

    public void setMinAhnTxnAmt(String minAhnTxnAmt) {
        this.minAhnTxnAmt = minAhnTxnAmt;
    }

    /**
     * 退款id
     * @return id 退款id
     */
    public String getId() {
        return id;
    }

    /**
     * 退款id
     * @param id 退款id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    /**
     * 交易功能号(01：消费撤销, 02：退货)
     * @return txn_fcn_no 交易功能号(01：消费撤销, 02：退货)
     */
    public String getTxnFcnNo() {
        return txnFcnNo;
    }

    /**
     * 交易功能号(01：消费撤销, 02：退货)
     * @param txnFcnNo 交易功能号(01：消费撤销, 02：退货)
     */
    public void setTxnFcnNo(String txnFcnNo) {
        this.txnFcnNo = txnFcnNo == null ? null : txnFcnNo.trim();
    }

    /**
     * 原商户订单号
     * @return origin_ordr_id 原商户订单号
     */
    public String getOriginOrdrId() {
        return originOrdrId;
    }

    /**
     * 原商户订单号
     * @param originOrdrId 原商户订单号
     */
    public void setOriginOrdrId(String originOrdrId) {
        this.originOrdrId = originOrdrId == null ? null : originOrdrId.trim();
    }

    /**
     * 退款订单号
     * @return refund_ordr_id 退款订单号
     */
    public String getRefundOrdrId() {
        return refundOrdrId;
    }

    /**
     * 退款订单号
     * @param refundOrdrId 退款订单号
     */
    public void setRefundOrdrId(String refundOrdrId) {
        this.refundOrdrId = refundOrdrId == null ? null : refundOrdrId.trim();
    }

    /**
     * 退款金额
     * @return ahn_txn_amt 退款金额
     */
    public String getAhnTxnAmt() {
        return ahnTxnAmt;
    }

    /**
     * 退款金额
     * @param ahnTxnAmt 退款金额
     */
    public void setAhnTxnAmt(String ahnTxnAmt) {
        this.ahnTxnAmt = ahnTxnAmt;
    }

    /**
     * 退款项描述
     * @return txn_itm_dsc 退款项描述
     */
    public String getTxnItmDsc() {
        return txnItmDsc;
    }

    /**
     * 退款项描述
     * @param txnItmDsc 退款项描述
     */
    public void setTxnItmDsc(String txnItmDsc) {
        this.txnItmDsc = txnItmDsc == null ? null : txnItmDsc.trim();
    }

    /**
     * 累计退款金额
     * @return alrd_rfnd_amt 累计退款金额
     */
    public String getAlrdRfndAmt() {
        return alrdRfndAmt;
    }

    /**
     * 累计退款金额
     * @param alrdRfndAmt 累计退款金额
     */
    public void setAlrdRfndAmt(String alrdRfndAmt) {
        this.alrdRfndAmt = alrdRfndAmt;
    }


    @Override
    public String toString() {
        return "RcvRefundOrder{" +
                "id='" + id + '\'' +
                ", mrchId='" + mrchId + '\'' +
                ", insideMrchId='" + insideMrchId + '\'' +
                ", createDatetime='" + createDatetime + '\'' +
                ", modifyDatetime='" + modifyDatetime + '\'' +
                ", txnStatus='" + txnStatus + '\'' +
                ", txnDt='" + txnDt + '\'' +
                ", txnTm='" + txnTm + '\'' +
                ", txnFcnNo='" + txnFcnNo + '\'' +
                ", originOrdrId='" + originOrdrId + '\'' +
                ", refundOrdrId='" + refundOrdrId + '\'' +
                ", ahnTxnAmt='" + ahnTxnAmt + '\'' +
                ", txnItmDsc='" + txnItmDsc + '\'' +
                ", alrdRfndAmt='" + alrdRfndAmt + '\'' +
                ", ordrAmt='" + ordrAmt + '\'' +
                ", ordrNO='" + ordrNo + '\'' +
                ", sysType='" + sysType + '\'' +
                ", tradeState='" + tradeState + '\'' +
                ", tradeStateDsc='" + tradeStateDsc + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", maxAhnTxnAmt='" + maxAhnTxnAmt + '\'' +
                ", minAhnTxnAmt='" + minAhnTxnAmt + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
