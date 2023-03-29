package com.example.justtest.controller.rcv;

import com.example.justtest.service.IRCVReportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by
 * 20220611
 */
@RestController
@RequestMapping("/rcvmrchtradereportdata")
public class RcvMrchTradeReportDataController {
    
    @Autowired
    private IRCVReportDataService ircvReportDataService;

    /**
     * 商户交易统计报表数据
     */
    @ExceptionHandler(value = Exception.class)
    @GetMapping("/rcvmrchtradereport")
    public void rcvMrchTradeReport(@RequestParam("reportDate") String reportDate) throws Exception
    {
        try {
            ircvReportDataService.rcvmrchtradereport(reportDate);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
