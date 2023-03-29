package com.example.justtest.jobtask.api;

import com.example.justtest.constant.jobtask.ServiceNameConstants;
import com.example.justtest.factory.RemoteRcvMrchReportFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 收单定时任务
 *
 * @author zhangyd
 */
@Service
@FeignClient(contextId = "remoteRcvMrchReportService", value = ServiceNameConstants.RCV_MRCH_REPORT_SERVICE, fallbackFactory = RemoteRcvMrchReportFallbackFactory.class)
public interface RemoteRcvMrchReportService {

    //商户交易统计
    @PostMapping("/rcvmrchtradereportdata/rcvmrchtradereport")
    void rcvMrchTradeReport(@RequestParam("reportDate") String reportDate) throws Exception;
}