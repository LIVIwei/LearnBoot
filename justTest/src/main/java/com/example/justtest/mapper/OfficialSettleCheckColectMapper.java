package com.example.justtest.mapper;

import com.example.justtest.domain.CheckPathDO;
import com.example.justtest.domain.CheckPathDetialDO;
import com.example.justtest.domain.CheckResultDO;
import com.example.justtest.domain.OfficialCheckCollectDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 运营机构对公交易数据
 * @author: zhangp
 * @date: 2021/3/11 15:36
 */

 @Mapper
 public interface OfficialSettleCheckColectMapper {

     int insert(OfficialCheckCollectDO checkCollectDO);

    /**
     * 批量插入数据
     *
     * @param list
     * @return
     */
     int insertByBatch(List<OfficialCheckCollectDO> list);

     List<OfficialCheckCollectDO> selectCheckCollect(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty);

     List<CheckPathDetialDO> selectCheckCollectCatchCheckPathDetia(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty);

     List<CheckPathDO> selectCollectSumByMsgType(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty);

     List<CheckPathDO> selectCollectSumTotal(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty);

    /**
     * 查询金融交易登记表当前批次的数据数量
     *

     * @return
     */
     int selectPayTranstionDetailCount(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty);

    /**
     * 查询金融交易登记表当前批次的数据
     *
     * @param datasource

     * @param beginNum   给定值时，使用批量查询方式，如果不赋值则查询所有
     * @param rowCount
     * @return
     */
     //List<CorpCheckCollectDO> selectPayTranstionDetails( String batchId, Long beginNum, Long rowCount);

    /**
     * 将查询金融交易登记表数据导入文件
     *

     * @param fileName
     * @return
     */
    List<OfficialCheckCollectDO> intoFilePayTranstionDetails(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty, @Param("fileName") String fileName, @Param("startrow") Integer startrow, @Param("endrow") Integer endrow);


    /**
     * 查询通道对账明细表中对账异常的数据总数
     *
     * @param

     * @return
     */
     int selectPathDetailForNotMatchCount(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty);

    /**
     * 查询通道对账明细表中对账异常的数据
     *

     * @return
     */
     List<CheckResultDO> selectPathDetailForNotMatch(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty,
                                                     @Param("dataType") String dataType, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 查询我行有，人行没有的交易数据总数
     *
     * @param

     * @return
     */
     int selectCollectWithPbocNotFoundCount(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty);

     List<CheckResultDO> selectCollectWithPbocNotFound(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty,
                                                       @Param("dataType") String dataType, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 查询金融交易登记表当前批次的数据
     *

     * @param msgIdList
     * @return
     */
     List<OfficialCheckCollectDO> selectPayTranstionDetailsByMsgId(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty, @Param("list") List<String> msgIdList);

     int replaceIntoBatch(OfficialCheckCollectDO CorpCheckCollectDO);
    /**
     * 查询通道对账明细表中对账结果数据
     *
     * @param

     * @return
     */
     List<CheckResultDO> selectPathDetailByMsgIdList(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty,
                                                     @Param("dataType") String dataType, @Param("list") List<String> msgIdList);

     @Delete("delete from OFFICIAL_BATCH_CHECKCOLLECT where paydate = #{payDate} and crdtparty=#{crdtParty}")
     int deleteByBatchId(@Param("payDate") String settleDate, @Param("crdtParty") String crdtparty);
}
