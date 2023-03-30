package com.example.livi.service.impl;

import com.example.livi.service.IDtlFileParseCibService;
import com.example.livi.service.ISettleTaskExecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LIVI
 * @Time: 2023/03/16  17:11
 * @Description:执行服务
 */
@Service
public class SettleTaskExecServiceImpl implements ISettleTaskExecService {

    @Autowired
    private IDtlFileParseCibService dtlFileParseCibService;

    @Override
    public void runTaskGroup(String settleDate, String crdtparty, String digitalEnvelope) throws Exception {
        runTask(settleDate,crdtparty);
    }

    private void runTask(String settleDate, String crdtparty) throws Exception {
        dtlFileParseCibService.parse(settleDate,crdtparty);
    }

    // @Override
    // public void run(SettleTaskExecDOPerson taskExec) {
    //
    // }
}
