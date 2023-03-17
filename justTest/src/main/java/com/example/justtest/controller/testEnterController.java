package com.example.justtest.controller;

import com.example.justtest.service.ISettleTaskExecService;
import com.example.justtest.web.controller.BaseController;
import com.example.justtest.web.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: LIVI
 * @Time: 2023/03/16  15:27
 * @Description: 测试入口
 */
@Controller
@RequestMapping("/justTest")
public class testEnterController extends BaseController {
    @Autowired
    private ISettleTaskExecService execService;
    @GetMapping("/begin")
    public TableDataInfo carryForward(@RequestParam("settleDate") String settleDate) throws Exception {
        String crdtparty= "1245212454121";
        execService.runTaskGroup(settleDate, crdtparty, null);
        return null;
    }
}
