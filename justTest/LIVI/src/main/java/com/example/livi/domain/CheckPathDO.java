package com.example.livi.domain;

import com.example.livi.annotation.Excel;
import com.example.livi.enums.ProcessStsCdEnum;

/**
 * 批量 对账汇总表
 */
public class CheckPathDO {
    @Excel(
            name = "平台日期"
    )
    private String payDate;
//    @Excel(
//            name = "平台流水"
//    )
    private String paySerno;
    private String payTime;
    @Excel(
            name = "报文标识号"
    )
    private String msgId;
    @Excel(
            name = "报文发送时间"
    )
    private String senderDateTime;
    @Excel(
            name = "发起机构"
    )
    private String instgDrctPty;
    @Excel(
            name = "接收机构"
    )
    private String instdDrctPty;
    @Excel(
            name = "批次日期"
    )
    private String batchDate;
    private String remark;
    private String digitalEnvelope;
    @Excel(
            name = "交易批次号"
    )
    private String batchId;
    @Excel(
            name = "总笔数"
    )
    private String countNum;
    @Excel(
            name = "总金额"
    )
    private String countAmt;
    @Excel(
            name = "总订单金额"
    )
    private String countOrdrAmt;
    @Excel(
            name = "总划账金额"
    )
    private String countRemitAmt;
    private String ccy;
    @Excel(name = "交易类型", readConverterExp = "dcep.221.001.01=兑回,dcep.225.001.01=兑出,dcep.227.001.01=汇款兑出,dcep.801.001.01=贷记调账")
    private String msgType;
    @Excel(
            name = "付款笔数"
    )
    private String dBITCountNum;
    @Excel(
            name = "付款金额"
    )
    private String dBITCountAmt;
    @Excel(
            name = "收款笔数"
    )
    private String cRDTCountNum;
    @Excel(
            name = "收款金额"
    )
    private String cRDTCountAmt;
    private ProcessStsCdEnum msgBizStatus;
    private String msgCountNum;
    private String msgCountAmt;
    private String msgDBITCountNum;
    private String msgDBITCountAmt;
    private String msgCRDTCountNum;
    private String msgCRDTCountAmt;

    private String checkStatus;
    private String lastUpDate;
    private String lastUpTime;
    @Excel(name = "对账标识", readConverterExp = "FANS=状态不符，我行失败，人行成功,SAME=对平,MORE=我行记录多,LESS=我行记录少,DIFF=不平,EXPT=状态不符，即异常,INIT=未对账,SANF=状态不符，我行成功，人行失败")
    private String realCheckStatus;

    private String sysType;//运营机构标识

    public CheckPathDO() {
    }

    public String getPayDate() {
        return this.payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPaySerno() {
        return this.paySerno;
    }

    public void setPaySerno(String paySerno) {
        this.paySerno = paySerno;
    }

    public String getPayTime() {
        return this.payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getSenderDateTime() {
        return this.senderDateTime;
    }

    public void setSenderDateTime(String senderDateTime) {
        this.senderDateTime = senderDateTime;
    }

    public String getInstgDrctPty() {
        return this.instgDrctPty;
    }

    public void setInstgDrctPty(String instgDrctPty) {
        this.instgDrctPty = instgDrctPty;
    }

    public String getInstdDrctPty() {
        return this.instdDrctPty;
    }

    public void setInstdDrctPty(String instdDrctPty) {
        this.instdDrctPty = instdDrctPty;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDigitalEnvelope() {
        return this.digitalEnvelope;
    }

    public void setDigitalEnvelope(String digitalEnvelope) {
        this.digitalEnvelope = digitalEnvelope;
    }

    public String getBatchDate() {
        return this.batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public String getBatchId() {
        return this.batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getCountNum() {
        return this.countNum;
    }

    public void setCountNum(String countNum) {
        this.countNum = countNum;
    }

    public String getCountAmt() {
        return this.countAmt;
    }

    public void setCountAmt(String countAmt) {
        this.countAmt = countAmt;
    }

    public String getCcy() {
        return this.ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getDBITCountNum() {
        return this.dBITCountNum;
    }

    public void setDBITCountNum(String dBITCountNum) {
        this.dBITCountNum = dBITCountNum;
    }

    public String getDBITCountAmt() {
        return this.dBITCountAmt;
    }

    public void setDBITCountAmt(String dBITCountAmt) {
        this.dBITCountAmt = dBITCountAmt;
    }

    public String getCRDTCountNum() {
        return this.cRDTCountNum;
    }

    public void setCRDTCountNum(String cRDTCountNum) {
        this.cRDTCountNum = cRDTCountNum;
    }

    public String getCRDTCountAmt() {
        return this.cRDTCountAmt;
    }

    public void setCRDTCountAmt(String cRDTCountAmt) {
        this.cRDTCountAmt = cRDTCountAmt;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public ProcessStsCdEnum getMsgBizStatus() {
        return this.msgBizStatus;
    }

    public void setMsgBizStatus(ProcessStsCdEnum msgBizStatus) {
        this.msgBizStatus = msgBizStatus;
    }

    public String getMsgCountNum() {
        return this.msgCountNum;
    }

    public void setMsgCountNum(String msgCountNum) {
        this.msgCountNum = msgCountNum;
    }

    public String getMsgCountAmt() {
        return this.msgCountAmt;
    }

    public void setMsgCountAmt(String msgCountAmt) {
        this.msgCountAmt = msgCountAmt;
    }

    public String getMsgDBITCountNum() {
        return this.msgDBITCountNum;
    }

    public void setMsgDBITCountNum(String msgDBITCountNum) {
        this.msgDBITCountNum = msgDBITCountNum;
    }

    public String getMsgDBITCountAmt() {
        return this.msgDBITCountAmt;
    }

    public void setMsgDBITCountAmt(String msgDBITCountAmt) {
        this.msgDBITCountAmt = msgDBITCountAmt;
    }

    public String getMsgCRDTCountNum() {
        return this.msgCRDTCountNum;
    }

    public void setMsgCRDTCountNum(String msgCRDTCountNum) {
        this.msgCRDTCountNum = msgCRDTCountNum;
    }

    public String getMsgCRDTCountAmt() {
        return this.msgCRDTCountAmt;
    }

    public void setMsgCRDTCountAmt(String msgCRDTCountAmt) {
        this.msgCRDTCountAmt = msgCRDTCountAmt;
    }

    public String getCheckStatus() {
        return this.checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getLastUpDate() {
        return this.lastUpDate;
    }

    public void setLastUpDate(String lastUpDate) {
        this.lastUpDate = lastUpDate;
    }

    public String getLastUpTime() {
        return this.lastUpTime;
    }

    public void setLastUpTime(String lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getRealCheckStatus() {
        return realCheckStatus;
    }

    public void setRealCheckStatus(String realCheckStatus) {
        this.realCheckStatus = realCheckStatus;
    }

    public String getCountOrdrAmt() {
        return countOrdrAmt;
    }

    public void setCountOrdrAmt(String countOrdrAmt) {
        this.countOrdrAmt = countOrdrAmt;
    }

    public String getCountRemitAmt() {
        return countRemitAmt;
    }

    public void setCountRemitAmt(String countRemitAmt) {
        this.countRemitAmt = countRemitAmt;
    }

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    @Override
    public String toString() {
        return "CheckPathDO{" +
                "payDate='" + payDate + '\'' +
                ", paySerno='" + paySerno + '\'' +
                ", payTime='" + payTime + '\'' +
                ", msgId='" + msgId + '\'' +
                ", senderDateTime='" + senderDateTime + '\'' +
                ", instgDrctPty='" + instgDrctPty + '\'' +
                ", instdDrctPty='" + instdDrctPty + '\'' +
                ", batchDate='" + batchDate + '\'' +
                ", remark='" + remark + '\'' +
                ", digitalEnvelope='" + digitalEnvelope + '\'' +
                ", batchId='" + batchId + '\'' +
                ", countNum='" + countNum + '\'' +
                ", countAmt='" + countAmt + '\'' +
                ", countOrdrAmt='" + countOrdrAmt + '\'' +
                ", countRemitAmt='" + countRemitAmt + '\'' +
                ", ccy='" + ccy + '\'' +
                ", msgType='" + msgType + '\'' +
                ", dBITCountNum='" + dBITCountNum + '\'' +
                ", dBITCountAmt='" + dBITCountAmt + '\'' +
                ", cRDTCountNum='" + cRDTCountNum + '\'' +
                ", cRDTCountAmt='" + cRDTCountAmt + '\'' +
                ", msgBizStatus=" + msgBizStatus +
                ", msgCountNum='" + msgCountNum + '\'' +
                ", msgCountAmt='" + msgCountAmt + '\'' +
                ", msgDBITCountNum='" + msgDBITCountNum + '\'' +
                ", msgDBITCountAmt='" + msgDBITCountAmt + '\'' +
                ", msgCRDTCountNum='" + msgCRDTCountNum + '\'' +
                ", msgCRDTCountAmt='" + msgCRDTCountAmt + '\'' +
                ", checkStatus=" + checkStatus +
                ", lastUpDate='" + lastUpDate + '\'' +
                ", lastUpTime='" + lastUpTime + '\'' +
                ", realCheckStatus='" + realCheckStatus + '\'' +
                ", sysType='" + sysType + '\'' +
                '}';
    }
}

