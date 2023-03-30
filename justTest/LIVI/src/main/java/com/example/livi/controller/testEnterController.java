package com.example.livi.controller;

import com.example.livi.service.ISettleTaskExecService;
import com.example.livi.web.controller.BaseController;
import com.example.livi.web.page.TableDataInfo;
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
        String crdtparty= "C1030935001347";
        execService.runTaskGroup(settleDate, crdtparty, null);
        return null;
    }
}
