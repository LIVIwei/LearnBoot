package com.example.justtest.factory;

import com.example.justtest.jobtask.api.RemoteRcvMrchReportService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Component;

/**
 * 收单交易统计降级处理
 *
 * @author
 */
@Component
public class RemoteRcvMrchReportFallbackFactory implements FallbackFactory<RemoteRcvMrchReportService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteRcvMrchReportFallbackFactory.class);

    @Override
    public RemoteRcvMrchReportService create(Throwable throwable)
    {
        log.error("交行商户交易统计服务调用失败:  ", throwable.getMessage());
        return reportDate -> {
            throw new Exception(throwable.getMessage());
        };
    }
}
