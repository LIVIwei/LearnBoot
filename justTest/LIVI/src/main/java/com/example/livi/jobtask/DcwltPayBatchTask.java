package com.example.livi.jobtask;

import com.alibaba.fastjson.JSONObject;
import com.example.livi.domain.jobtask.TaskResult;
import com.example.livi.utils.DateUtil.DateUtil;
import com.example.livi.utils.DateUtil.DateUtils;
import com.example.livi.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 模块定时任务调度测试
 *
 * 注意
 * 所有方法的返回值类型必须为 TaskResult
 * 所有方法只能throws TaskException类型异常
 *
 * @author
 */

@Component("dcwltPayBatchTask")
public class DcwltPayBatchTask {
    // @Autowired
    // private RemotePersonPayBatchService remotePersonPayBatchService;
    // @Autowired
    // RemoteRcvMrchReportService remoteRcvMrchReportService;

    /**
     * 直连交行 明细对账调度
     * 注意 交行对账文件每天 15:00-16:00 下发 昨日14:00-今日14:00 的数据文件
     * 所以 定时任务必须在16:00 之后执行
     * @param reportDate
     * @param dataType 对账类型
     * @return
     * @throws Exception
     */
    public TaskResult reconcilitionBcm(String reportDate, String dataType) throws Exception {
        TaskResult result = new TaskResult();
        // 解析成日期字符串
        String params = DateUtils.parseTaskDate(reportDate);
        //此处做一个T-1 的时间处理；因为交行对账文件跨日 昨日14:00-今日14:00 的数据文件
        //这样就可以执行执行 T-1 的对账任务，下载当日的交行文件（业务中已处理）
        //同时下载完整的t-1 的核心对账文件，都不受影响

        //获取前一天
        Date Date = DateUtil.DEFAULT_DATE_FORMATTER.parse(params);
        Date settleDateBefore = DateUtils.addDays(Date, -1);
        params = DateUtil.DEFAULT_DATE_FORMATTER.format(settleDateBefore);

        // 把字符串用单引号包裹
        result.setInvokeTarget("personbatch.carryForward(" + StringUtils.toTaskString(params) + ")");
        // 初始化执行结果为失败
        result.setSuccess(false);

        System.out.println("执行方法：personbatch.carryForward(" + StringUtils.toTaskString(reportDate) + ")");

        try {
            // remotePersonPayBatchService.carryForward(params,dataType);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            // 必须转成JSONString
            throw new Exception(JSONObject.toJSONString(result));
        }

        // 执行结果，有返回值设置返回值，没有不设置
        // result.setRet();
        // 执行成功
        result.setSuccess(true);
        return result;
    }

    /**
     * 商户交易统计报表定时任务
     * @param reportDate
     * @return
     * @throws Exception
     */
    public TaskResult rcvMrchTradeReport(String reportDate) throws Exception {
        TaskResult result = new TaskResult();
        // 解析成日期字符串
        String params = DateUtils.parseTaskDate(reportDate);

        //此处做一个T-1 的时间处理，统计前一天的报表
        //获取前一天
        Date Date = DateUtil.DEFAULT_DATE_FORMATTER.parse(params);
        Date settleDateBefore = DateUtils.addDays(Date, -1);
        params = DateUtil.DEFAULT_DATE_FORMATTER.format(settleDateBefore);

        // 把字符串用单引号包裹
        result.setInvokeTarget("dcwltPayBatchTask.rcvMrchTradeReport(" + StringUtils.toTaskString(params) + ")");
        // 初始化执行结果为失败
        result.setSuccess(false);

        System.out.println("执行方法：dcwltPayBatchTask.rcvMrchTradeReport(" + StringUtils.toTaskString(reportDate) + ")");

        try {
            // remoteRcvMrchReportService.rcvMrchTradeReport(params);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            // 必须转成JSONString
                throw new Exception(JSONObject.toJSONString(result));
        }

        // 执行结果，有返回值设置返回值，没有不设置
        // result.setRet();
        // 执行成功
        result.setSuccess(true);
        return result;
    }
}
