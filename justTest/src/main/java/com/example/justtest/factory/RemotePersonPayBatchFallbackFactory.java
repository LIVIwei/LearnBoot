package com.example.justtest.factory;

import com.example.justtest.jobtask.api.RemotePersonPayBatchService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付批量服务降级处理
 *
 * @author
 */
@Component
public class RemotePersonPayBatchFallbackFactory implements FallbackFactory<RemotePersonPayBatchService>
{
    private static final Logger log = LoggerFactory.getLogger(RemotePersonPayBatchFallbackFactory.class);

    @Override
    public RemotePersonPayBatchService create(Throwable throwable)
    {
        log.error("服务调用失败:  ", throwable.getMessage());
        return new RemotePersonPayBatchService()
        {
            @Override
            public void carryForward(String reportDate, String dataType) throws Exception {
                throw new Exception(throwable.getMessage());
            }
        };
    }
}
