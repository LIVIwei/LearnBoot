package com.example.livi.jobtask.api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 收单定时任务
 *
 * @author zhangyd
 */
// @FeignClient(contextId = "remoteRcvMrchReportService", value = ServiceNameConstants.RCV_MRCH_REPORT_SERVICE, fallbackFactory = RemoteRcvMrchReportFallbackFactory.class)
@Service
public interface RemoteRcvMrchReportService {

    //商户交易统计
    @PostMapping("/rcvmrchtradereportdata/rcvmrchtradereport")
    void rcvMrchTradeReport(@RequestParam("reportDate") String reportDate) throws Exception;
}