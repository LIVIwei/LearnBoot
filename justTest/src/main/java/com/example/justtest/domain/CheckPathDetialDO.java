package com.example.justtest.domain;

import com.example.justtest.annotation.Excel;

/**
 * 通道对账明细表
 */
public class CheckPathDetialDO {
    @Excel(name="业务日期")
    private String workdate;  //业务日期	VARCHAR	8
    @Excel(name="流水号")
    private String msgId;  //	报文标识号	VARCHAR	35
    //    @Excel(name="明细的报文标识号")
    private String dtlMsgId;  //	明细的报文标识号	VARCHAR	35
    @Excel(name="交易批次号")
    private String batchId;  //	交易批次号	VARCHAR	13

    @Excel(name="核心流水号")
    private String coreserno;   //核心流水号
    @Excel(name="交易类型", readConverterExp = "dcep.221.001.01=兑回,dcep.225.001.01=兑出,dcep.227.001.01=汇款兑出,dcep.801.001.01=贷记调账")
    private String msgType;  //	报文编号	VARCHAR	35
    @Excel(name="发起机构")
    private String instgDrctPty;  //	发起机构	VARCHAR	14
    @Excel(name="付款方")
    private String payerAccount;  //	付款人账号	VARCHAR	32
//    @Excel(name="付款方钱包Id")
    private String payerWalletId;  //	付款人账号	VARCHAR	32
    @Excel(name="收款方")
    private String payeeAccount;  //	收款人账号	VARCHAR	32
//    @Excel(name="收款方钱包Id")
    private String payeeWalletId;  //	收款人钱包ID	VARCHAR	34
    @Excel(name="货币代码")
    private String ccy;  //	货币代码	VARCHAR	3
    @Excel(name="金额")
    private String amount;  //	金额	VARCHAR	19
    @Excel(name="交易状态", readConverterExp = "PR99=未处理,PR00=成功,PR01=失败,PR02=处理中,PR03=推定成功,PR04=推定失败")
    private String dtlBizStatus;  //	业务状态	VARCHAR	4
    @Excel(name="对账标识", readConverterExp = "SAME=对平,MORE=核心记录多,LESS=核对报文多,DIFF=不平,SANF=状态不符，我行成功，人行失败,FANS=状态不符，我行失败，人行成功,EANS=状态不符，我行异常，人行成功,EANF=状态不符，我行异常，人行失败,PROC=状态不符，人行处理中,INIT=未对账")
    private String checkStatus;  //	对账标识	VARCHAR	1
    @Excel(name="最后更新日期")
    private String lastUpDate;  //	最后更新日期	VARCHAR	8
    @Excel(name="最后更新时间")
    private String lastUpTime;  //	最后更新时间	VARCHAR	6
    private String splitNum;  //	分片号	VARCHAR	2
    private String fileName;  //	文件名	VARCHAR	64
    private String dtlBizTime;  //	业务处理时间	VARCHAR	14
    private String dBITParty;  //	付款机构编码	VARCHAR	14
    private String cRDTParty;  //	收款机构编码	VARCHAR	14
    private String dtlDesc;  //	交易描述信息	VARCHAR	384
    private String payeeName;  //	收款人名称	VARCHAR	180
    private String payerName;  //	收款人名称	VARCHAR	180
    private String ognlMsgType;  //	原报文编号	VARCHAR	35
    private String ognlMsgId;  //	原报文标识号	VARCHAR	35

    private String dbitCashBoxParty; //付款钱柜运营机构编码 NVARCHAR2(14)
    private String crdtCashBoxParty; //收款钱柜运营机构编码 NVARCHAR2(14)

    private String innerAcctId;  //核心账户
    private String direct;      //业务方向

    public String getWorkdate() {
        return workdate;
    }

    public void setWorkdate(String workdate) {
        this.workdate = workdate;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getSplitNum() {
        return splitNum;
    }

    public void setSplitNum(String splitNum) {
        this.splitNum = splitNum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDtlBizTime() {
        return dtlBizTime;
    }

    public void setDtlBizTime(String dtlBizTime) {
        this.dtlBizTime = dtlBizTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getDtlMsgId() {
        return dtlMsgId;
    }

    public void setDtlMsgId(String dtlMsgId) {
        this.dtlMsgId = dtlMsgId;
    }

    public String getInstgDrctPty() {
        return instgDrctPty;
    }

    public void setInstgDrctPty(String instgDrctPty) {
        this.instgDrctPty = instgDrctPty;
    }

    public String getDBITParty() {
        return dBITParty;
    }

    public void setDBITParty(String dBITParty) {
        this.dBITParty = dBITParty;
    }

    public String getCRDTParty() {
        return cRDTParty;
    }

    public void setCRDTParty(String cRDTParty) {
        this.cRDTParty = cRDTParty;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDtlBizStatus() {
        return dtlBizStatus;
    }

    public void setDtlBizStatus(String dtlBizStatus) {
        this.dtlBizStatus = dtlBizStatus;
    }

    public String getDtlDesc() {
        return dtlDesc;
    }

    public void setDtlDesc(String dtlDesc) {
        this.dtlDesc = dtlDesc;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public String getPayeeWalletId() {
        return payeeWalletId;
    }

    public void setPayeeWalletId(String payeeWalletId) {
        this.payeeWalletId = payeeWalletId;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public String getOgnlMsgType() {
        return ognlMsgType;
    }

    public void setOgnlMsgType(String ognlMsgType) {
        this.ognlMsgType = ognlMsgType;
    }

    public String getOgnlMsgId() {
        return ognlMsgId;
    }

    public void setOgnlMsgId(String ognlMsgId) {
        this.ognlMsgId = ognlMsgId;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getLastUpDate() {
        return lastUpDate;
    }

    public void setLastUpDate(String lastUpDate) {
        this.lastUpDate = lastUpDate;
    }

    public String getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(String lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getCoreserno() {
        return coreserno;
    }

    public void setCoreserno(String coreserno) {
        this.coreserno = coreserno;
    }


    public String getDbitCashBoxParty() {
        return dbitCashBoxParty;
    }

    public void setDbitCashBoxParty(String dbitCashBoxParty) {
        this.dbitCashBoxParty = dbitCashBoxParty;
    }

    public String getCrdtCashBoxParty() {
        return crdtCashBoxParty;
    }

    public void setCrdtCashBoxParty(String crdtCashBoxParty) {
        this.crdtCashBoxParty = crdtCashBoxParty;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerWalletId() {
        return payerWalletId;
    }

    public void setPayerWalletId(String payerWalletId) {
        this.payerWalletId = payerWalletId;
    }

    public String getdBITParty() {
        return dBITParty;
    }

    public void setdBITParty(String dBITParty) {
        this.dBITParty = dBITParty;
    }

    public String getcRDTParty() {
        return cRDTParty;
    }

    public void setcRDTParty(String cRDTParty) {
        this.cRDTParty = cRDTParty;
    }

    public String getInnerAcctId() {
        return innerAcctId;
    }

    public void setInnerAcctId(String innerAcctId) {
        this.innerAcctId = innerAcctId;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    @Override
    public String toString() {
        return "CheckPathDetialDO{" +
                "coreserno='" + coreserno + '\'' +
                ", workdate='" + workdate + '\'' +
                ", dtlMsgId='" + dtlMsgId + '\'' +
                ", batchId='" + batchId + '\'' +
                ", msgId='" + msgId + '\'' +
                ", msgType='" + msgType + '\'' +
                ", instgDrctPty='" + instgDrctPty + '\'' +
                ", payerAccount='" + payerAccount + '\'' +
                ", payeeAccount='" + payeeAccount + '\'' +
                ", ccy='" + ccy + '\'' +
                ", amount='" + amount + '\'' +
                ", dtlBizStatus='" + dtlBizStatus + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", lastUpDate='" + lastUpDate + '\'' +
                ", lastUpTime='" + lastUpTime + '\'' +
                ", splitNum='" + splitNum + '\'' +
                ", fileName='" + fileName + '\'' +
                ", dtlBizTime='" + dtlBizTime + '\'' +
                ", dBITParty='" + dBITParty + '\'' +
                ", cRDTParty='" + cRDTParty + '\'' +
                ", dtlDesc='" + dtlDesc + '\'' +
                ", payeeName='" + payeeName + '\'' +
                ", payeeWalletId='" + payeeWalletId + '\'' +
                ", ognlMsgType='" + ognlMsgType + '\'' +
                ", ognlMsgId='" + ognlMsgId + '\'' +
                ", dbitCashBoxParty='" + dbitCashBoxParty + '\'' +
                ", crdtCashBoxParty='" + crdtCashBoxParty + '\'' +
                '}';
    }
}
