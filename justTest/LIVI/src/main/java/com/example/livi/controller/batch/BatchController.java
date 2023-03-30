package com.example.livi.controller.batch;

import com.example.livi.enums.TaskGroupEnum;
import com.example.livi.service.ISettleTaskExecService;
import com.example.livi.web.controller.BaseController;
import com.example.livi.web.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 批次号查询
 */
@RestController
@RequestMapping("/personbatch")
public class BatchController extends BaseController {
    @Autowired
    private ISettleTaskExecService execService;
    // @Autowired
    // private ReconsummaryChkMapper reconsummaryChkMapper;
    // @Autowired
    // private SettleTaskGroupExecMapper settleTaskGroupExecMapper;

    //明细对账,增加对账类型
    @GetMapping("/carryForward")
    public TableDataInfo carryForward(@RequestParam("settleDate") String settleDate, @RequestParam("dataType") String dataType) throws Exception {
        String crdtparty= "";//指定交行 机构代码
        logger.info("对账类型为" + dataType);
        //根据数据类型执行对应对账任务组
        switch (dataType){
            //交行个人对账
            case "FBP" :
                execService.runTaskGroup(settleDate, crdtparty, TaskGroupEnum.CHK_DTL.getCode());
                break;
            //交行
            case "FBO":
                execService.runTaskGroup(settleDate, crdtparty, TaskGroupEnum.CHK_BCM_OFFICIAL.getCode());
                break;
            //交行收单对账
            case "COMM":
                execService.runTaskGroup(settleDate, crdtparty, TaskGroupEnum.CHK_COMM_RECEIVE.getCode());
                break;
            //中行个人对账
            case "FOP":
                break;
            //中行对公对账
            case "FOO":
                //中行机构代码
                // crdtparty = AppConstant.getBOCFinancialInstitutionCd();
                execService.runTaskGroup(settleDate, crdtparty, "");
                break;
            //兴业个人对账
            case "FCP" :
                //兴业机构代码
                // crdtparty = AppConstant.getCIBFinancialInstitutionCd();
                execService.runTaskGroup(settleDate, crdtparty, TaskGroupEnum.CHK_CIB_PERSON.getCode());
                break;
            //兴业对公对账
            case "FCO" :
                //兴业机构代码
                // crdtparty = AppConstant.getCIBFinancialInstitutionCd();
                execService.runTaskGroup(settleDate, crdtparty, TaskGroupEnum.CHK_CIB_OFFICIAL.getCode());
                break;
            default:break;
        }
//        execService.runTaskGroup(settleDate, crdtparty, TaskGroupEnum.CHK_DTL.getCode(), null);
        return null;
    }

    //todo 替换
    //获取明细对账 任务即可 用于重发对账继续走流程
//     @GetMapping("/list")
//     public TableDataInfo list(SettleTaskGroupExecDOPerson settleTaskGroupExecDOPerson) {
//         startPage();
//         settleTaskGroupExecDOPerson.setTaskGroupCode(TaskGroupEnum.CHK_DTL.getCode());
//          //获取明细对账 任务即可
//         List<SettleTaskGroupExecDOPerson> reconSummaryChkDOS= settleTaskGroupExecMapper.select(settleTaskGroupExecDOPerson);
//         return getDataTable(reconSummaryChkDOS);
//     }
//
//     @PostMapping("/export")
//     public void export(HttpServletResponse response, ReconSummaryChkDO reconSummaryChkDO) throws IOException {
//         String checkstatus = reconSummaryChkDO.getCheckstatus();
//         String coreCheckstatus = reconSummaryChkDO.getCoreCheckstatus();
//         if (StringUtils.isNotBlank(checkstatus) || StringUtils.isNotBlank(coreCheckstatus)) {
//             String param = (StringUtils.isBlank(checkstatus) ? "%" : checkstatus) + "-" +
//                     (StringUtils.isBlank(coreCheckstatus) ? "%" : coreCheckstatus);
//             reconSummaryChkDO.setRemark(param);
//         }
//         List<ReconSummaryChkDO> list = reconsummaryChkMapper.selectReconsummaryChkList(reconSummaryChkDO);
//         logger.info("查出来的数据为：{}",list!=null?list.size():0);
//         list = list.stream().sorted(Comparator.comparing(ReconSummaryChkDO::getBatchId).reversed()).collect(Collectors.toList());
//         list.stream().forEach(s -> {
//             String remark = s.getRemark();
//             if(StringUtils.isNotEmpty(remark)) {
//                 String[] split = remark.split("-");
//                 if (split.length == 2) {
//                     s.setCheckstatus(split[0]);
//                     s.setCoreCheckstatus(split[1]);
// //                    String checkStatus = split[0];
// //                    String coreCheckStatus = split[1];
// //                    checkStatus = DictUtils.getDictCache("pro_stats", checkStatus);
// //                    coreCheckStatus = DictUtils.getDictCache("core_staut", coreCheckStatus);
// //                    s.setCheckstatus(StringUtils.equals(checkStatus, "T") ? "" : checkStatus);
// //                    s.setCoreCheckstatus(StringUtils.equals(coreCheckStatus, "T") ? "" : coreCheckStatus);
//                 }
//             }
//         });
//         ExcelUtil<ReconSummaryChkDO> util = new ExcelUtil<ReconSummaryChkDO>(ReconSummaryChkDO.class);
//         util.exportExcel(response, list, "process");
//     }
}
