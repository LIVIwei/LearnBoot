package com.example.justtest.service;


import com.example.justtest.domain.CheckPathDetialDO;

import java.util.List;

public interface IOfficialCheckPathDetailService {

    int replaceCheckPathDtl(List<CheckPathDetialDO> checkPathDetialDOS);

    /**
     * 统计当前批次两方都存在的情况下需要对账的总数
     * @param workdate

     * @return
     */
    public int selectCheckDetailCount(String workdate, String crdtParty);

    /**
     * 对人行的交易明细和我行的交易明细进行状态比对，然后更新结果状态, 不限制更新的条数
     */
    public int updateCheckStatusForMsgMatchWithoutLimit(String workdate, String crdtParty, List<String> msgIdList);

    /**
     * 对人行的交易明细和我行的交易明细进行状态比对，然后更新结果状态, 限制更新的条数
     * @param updateNumber 每次更新的记录数
     */
    public int updateCheckStatusForMsgMatchWithLimit(String workdate, String crdtParty, Integer updateNumber);

    public int insert(CheckPathDetialDO checkPathDetialDO);

    public List<CheckPathDetialDO> select(String workdate, String crdtParty, String checkstatus);

    public List<CheckPathDetialDO> selectCore(String startworkdate, String endworkdate, String msgId, String crdtParty, String checkstatus, String coreserno);
    
    public int insertByBatch(List<CheckPathDetialDO> checkPathDetialDOS);
    
    /**
     * 使用主键更新对账后的状态
     * @param msgId
     * @param dtlMsgId
     * @param checkStatus
     * @return
     */
    public int updateStatus(String msgId, String dtlMsgId, String checkStatus);
    
    /**
     * 查找当前日期下，给定的批次号中人行有数据，但我行没有的明细数据的总数
     * @param workdate
     
     * @return
     */
    public int selectPathDetailWhitCgbNotFoundCount(String workdate, String crdtParty);
    
    /**
     * 查找当前日期下，给定的批次号中人行有数据，但我行没有的明细数据
     * @param workdate
     
     * @return
     */
    public List<CheckPathDetialDO> selectPathDetailWhitCgbNotFound(String workdate, String crdtParty, Integer start, Integer end);


    /**
     * 查询当前的对账明细通过联合主键
     * @param mshId
     * @param dtlmsgId
     * @return
     */
    CheckPathDetialDO querySingle(String mshId, String dtlmsgId);

    int deleteByBatchId(String settleDate, String crdtParty);

    /**
     * 删除交易记录中钱包ID不是对公钱包的记录
     * @param batchId
     * @param crdtParty
     * @return
     */
    public int deleteWalletNotExists(String batchId, String crdtParty);
}
