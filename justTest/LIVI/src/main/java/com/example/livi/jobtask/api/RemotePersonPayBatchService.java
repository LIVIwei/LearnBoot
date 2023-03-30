package com.example.livi.jobtask.api;

import com.example.livi.constant.jobtask.ServiceNameConstants;
import com.example.livi.factory.RemotePersonPayBatchFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 支付批量服务
 *
 * @author zhangyd
 */
@FeignClient(contextId = "remotePersonPayBatchService", value = ServiceNameConstants.PERSON_PAY_BATCH_SERVICE, fallbackFactory = RemotePersonPayBatchFallbackFactory.class)
public interface RemotePersonPayBatchService {

    //直连交行 明细对账,增加对账类型参数
    @GetMapping("/personbatch/carryForward")
    public void carryForward(@RequestParam("settleDate")  String reportDate, @RequestParam("dataType")  String dataType) throws Exception;

}