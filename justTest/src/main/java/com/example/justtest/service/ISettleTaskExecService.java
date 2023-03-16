package com.example.justtest.service;

/**
 * @description: some desc
 * @author: zhangp
 * @date: 2021/3/9 16:41
 */
public interface ISettleTaskExecService {

    public void runTaskGroup(String settleDate, String crdtparty, String digitalEnvelope) throws Exception;

    // public void run(SettleTaskExecDOPerson taskExec);
}
