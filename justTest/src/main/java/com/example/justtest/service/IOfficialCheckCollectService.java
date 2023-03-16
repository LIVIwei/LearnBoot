package com.example.justtest.service;


import com.dcits.dcwlt.pay.api.model.CheckPathDO;
import com.dcits.dcwlt.pay.api.model.CheckPathDetialDO;
import com.dcits.dcwlt.pay.api.model.CheckResultDO;
import com.dcits.dcwlt.pay.api.model.OfficialCheckCollectDO;
import com.example.justtest.domain.CheckPathDetialDO;
import com.example.justtest.domain.OfficialCheckCollectDO;

import java.util.List;

public interface IOfficialCheckCollectService {

    /**
     * 插入数据
     * @param OfficialCheckCollectDO
     * @return
     */
    public int insert(OfficialCheckCollectDO OfficialCheckCollectDO);

    /**
     * 批量插入数据
     *
     * @param list
     * @return
     */
    public int insertByBatch(List<OfficialCheckCollectDO> list);

    /**
     * 文件导入
     *
     * @param fileName
     * @return
     */
    public void loadFileByBatch(String fileName);

    public List<OfficialCheckCollectDO> selectPayTranstionDetails(String settleDate, String crdtParty, String fileName, Integer startrow, Integer endrow);
    /**
     * 将数据从联机库导入文件
     *
     * @param fileName
     * @param startrow
     * @param endrow
     * @return
     */
    public int intoFilePayTranstionDetails(String settleDate, String crdtParty, String fileName, Integer startrow, Integer endrow);

    /**
     * 查询数据
     *
     * @param
     
     * @return
     */
    public List<OfficialCheckCollectDO> selectCheckCollect(String settleDate, String crdtParty);

    /**
     * 查询与解析入库表相同数据
     *
     * @param

     * @return
     */
    public List<CheckPathDetialDO> selectCheckCollectCatchCheckPathDetia(String settleDate, String crdtParty);


    /**
     * 分组汇总查询数据
     *
     * @param
     
     * @return
     */
    public List<CheckPathDO> selectCollectSumByMsgType(String settleDate, String crdtParty);

    /**
     * 分组汇总查询数据
     *
     * @param
     
     * @return
     */
    public List<CheckPathDO> selectCollectSumTotal(String settleDate, String crdtParty);

    /**
     * 查询金融交易登记表当前批次的数据数量
     *
     * @return
     */
    public int selectPayTranstionDetailCount(String settleDate, String crdtParty);


    /**
     * 查询我行有，人行没有的交易数据总数
     *
     * @param
     
     * @return
     */
    public int selectCollectWithPbocNotFoundCount(String settleDate, String crdtParty);

    /**
     * 查询我行有，人行没有的交易数据
     *
     * @param
     
     * @return
     */
    public List<CheckResultDO> selectCollectWithPbocNotFound(String settleDate, String crdtParty, String dataType, Integer start, Integer end);

    /**
     * 查询通道对账明细表中对账异常的数据总数
     *
     * @param
     
     * @return
     */
    public int selectPathDetailForNotMatchCount(String settleDate, String crdtParty);

    /**
     * 查询通道对账明细表中对账异常的数据
     *
     * @param
     
     * @return
     */
    public List<CheckResultDO> selectPathDetailForNotMatch(String settleDate, String crdtParty, String dataType, Integer start, Integer end);

    /**
     * 查询金融交易登记表当前批次的数据
     *
     
     
     * @param msgIdList
     * @return
     */
    public List<OfficialCheckCollectDO> selectPayTranstionDetailsByMsgId(String settleDate, String crdtParty, List<String> msgIdList);

    public int replaceIntoBatch(List<OfficialCheckCollectDO> list);

    /**
     * 查询通道对账明细表中对账结果数据
     *
     * @param
     
     * @return
     */
    public List<CheckResultDO> selectPathDetailByMsgIdList(String settleDate, String crdtParty, String dataType, List<String> msgIdList);

    public int deleteByBatchId(String settleDate, String crdtParty);
}
