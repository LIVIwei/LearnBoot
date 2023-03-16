package com.example.justtest.domain;


import lombok.Data;

/**
 *
 * @version 1.0.0
 * Description:对账汇总文件明细数据库实体
 * @Date 2021/1/5 14:57
 */
@Data
public class DtlFileInfDOPerson {
    // 报文标识
    private String msgId;
    //交易批次号
    private String batchId;

    //TODO 新增
    private String payDate;
    private String crdtParty;
    private String dataType;
    //源文件路径
    private String srcFilePath;
    //目标文件路径
    private String destFilePath;
    //文件名
    private String fileName;
    //最后更新日期
    private String lastUpDate;
    //最后更新时间
    private String lastUpTime;
    //init:未下载proc:下载中succ:已下载
    private String fileProcStatus;
    //本地文件路径
    private String localFilePath;
    //文件校验码，兴业下载文件使用
    private String fileVerifyCode;
    //文件类型
    private String fileType;

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

    public String getCrdtParty() {
        return crdtParty;
    }

    public void setCrdtParty(String crdtParty) {
        this.crdtParty = crdtParty;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getSrcFilePath() {
        return srcFilePath;
    }

    public void setSrcFilePath(String srcFilePath) {
        this.srcFilePath = srcFilePath;
    }

    public String getDestFilePath() {
        return destFilePath;
    }

    public void setDestFilePath(String destFilePath) {
        this.destFilePath = destFilePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getFileProcStatus() {
        return fileProcStatus;
    }

    public void setFileProcStatus(String fileProcStatus) {
        this.fileProcStatus = fileProcStatus;
    }

    public String getLocalFilePath() {
        return localFilePath;
    }

    public void setLocalFilePath(String localFilePath) {
        this.localFilePath = localFilePath;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "DtlFileInfDOPerson{" +
                "msgId='" + msgId + '\'' +
                ", batchId='" + batchId + '\'' +
                ", payDate='" + payDate + '\'' +
                ", crdtParty='" + crdtParty + '\'' +
                ", dataType='" + dataType + '\'' +
                ", srcFilePath='" + srcFilePath + '\'' +
                ", destFilePath='" + destFilePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", lastUpDate='" + lastUpDate + '\'' +
                ", lastUpTime='" + lastUpTime + '\'' +
                ", fileProcStatus='" + fileProcStatus + '\'' +
                ", localFilePath='" + localFilePath + '\'' +
                ", fileVerifyCode='" + fileVerifyCode + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
