package com.example.justtest.service.impl;


import com.example.justtest.domain.CheckPathDetialDO;
import com.example.justtest.mapper.OfficialSettleCheckPathDetailMapper;
import com.example.justtest.service.IOfficialCheckPathDetailService;
import com.example.justtest.utils.DateUtil.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * 通道对账明细表
 */
@Service
public class OfficialCheckPathDetailServiceImpl implements IOfficialCheckPathDetailService {
    //private static final String INSERT_SQL = "settleCheckPathDetailMapper.insert";
    //private static final String SELECT_SQL = "settleCheckPathDetailMapper.selectPathDetail";
    //private static final String REPLACE_SQL = "settleCheckPathDetailMapper.replace";

    @Autowired
    private OfficialSettleCheckPathDetailMapper settleCheckPathDetailMapper;

    @Override
    public int insert(CheckPathDetialDO checkPathDetialDO) {
        return settleCheckPathDetailMapper.insert(checkPathDetialDO);
    }

    @Override
    public List<CheckPathDetialDO> select(String workdate, String crdtParty,String checkstatus) {
        return settleCheckPathDetailMapper.selectPathDetail(workdate, crdtParty,checkstatus);
    }

    @Override
    public List<CheckPathDetialDO> selectCore(String startworkdate, String endworkdate, String msgId, String crdtParty,String checkstatus, String coreserno) {
        return settleCheckPathDetailMapper.selectPathDetailCore(startworkdate, endworkdate, msgId, crdtParty,checkstatus, coreserno);
    }

    @Override
    public int insertByBatch(List<CheckPathDetialDO> checkPathDetialDOS) {
    	return settleCheckPathDetailMapper.insertByBatch(checkPathDetialDOS);
    }
    
    @Override
    public int replaceCheckPathDtl(List<CheckPathDetialDO> checkPathDetialDOS) {
        return settleCheckPathDetailMapper.replace(checkPathDetialDOS);
    }
    
    /**
     * 统计当前批次两方都存在的情况下需要对账的总数
     * @param workdate
     * @param batchId
     * @return
     */
    @Override
    public int selectCheckDetailCount(String workdate, String crdtParty) {
    	return settleCheckPathDetailMapper.selectCheckDetailCount(workdate, crdtParty);
    }

    /**
     * 对人行的交易明细和我行的交易明细进行状态比对，然后更新结果状态, 不限制更新的条数
     */
    @Override
    public int updateCheckStatusForMsgMatchWithoutLimit(String workdate, String crdtParty, List<String> msgIdList) {
//    	Map<String, Object> map = new HashMap<String, Object>();
//    	map.put("workdate", workdate);
//    	map.put("batchId", batchId);
//    	if (msgIdList != null && !msgIdList.isEmpty()) {
//    		map.put("list", msgIdList);
//    	}
        return settleCheckPathDetailMapper.updateCheckStatusForMsgMatchWithoutLimit(workdate,crdtParty,msgIdList);
    }
    
    /**
     * 对人行的交易明细和我行的交易明细进行状态比对，然后更新结果状态, 限制更新的条数
     * @param updateNumber 每次更新的记录数
     */
    @Override
    public int updateCheckStatusForMsgMatchWithLimit(String workdate, String crdtParty, Integer updateNumber) {
    	return settleCheckPathDetailMapper.updateCheckStatusForMsgMatchWithLimit(workdate, crdtParty, updateNumber);
    }
    /**
     * 使用主键更新对账后的状态
     *
     * @param msgId
     * @param dtlMsgId
     * @param checkStatus
     * @return
     */
    @Override
    public int updateStatus(String msgId, String dtlMsgId, String checkStatus) {
        String date = DateUtil.getISODateTime();
        String time = "";
        try {
            date = DateUtil.getDateStr(date);
            time = DateUtil.getDefaultTime();
        } catch (ParseException pe) {
            date = "";
            time = "";
        }
        return settleCheckPathDetailMapper.updateStatus( msgId,date,time,dtlMsgId,checkStatus);
    }
    
    /**
     * 查找当前日期下，给定的批次号中人行有数据，但我行没有的明细数据的总数
     * @param workdate
     * @param batchId
     * @return
     */
    @Override
    public int selectPathDetailWhitCgbNotFoundCount(String workdate, String crdtParty) {
    	return settleCheckPathDetailMapper.selectPathDetailWhitCgbNotFoundCount(workdate,crdtParty);
    }
    /**
     * 查找当前日期下，给定的批次号中人行有数据，但我行没有的明细数据
     *
     * @param workdate
     * @param crdtParty
     * @return
     */
    @Override
    public List<CheckPathDetialDO> selectPathDetailWhitCgbNotFound(String workdate, String crdtParty, Integer start, Integer end) {
        return settleCheckPathDetailMapper.selectPathDetailWhitCgbNotFound(workdate,crdtParty,start,end);
    }

    @Override
    public CheckPathDetialDO querySingle(String mshId, String dtlmsgId) {
        return settleCheckPathDetailMapper.querySingle(mshId,dtlmsgId);
    }

    @Override
    public int deleteByBatchId(String settleDate, String crdtParty){
        return settleCheckPathDetailMapper.deleteByBatchId(settleDate,crdtParty);
    }

    /**
     * 删除交易记录中钱包ID不是对公钱包的记录
     * @param batchId
     * @param crdtParty
     * @return
     */
    @Override
    public int deleteWalletNotExists(String batchId, String crdtParty) {
        return settleCheckPathDetailMapper.deleteWalletNotExists(batchId,crdtParty);
    }
}
