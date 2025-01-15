package com.company.jmixbpmdemo.jobs;

import org.flowable.engine.RuntimeService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class StartProcessByQuartz implements Job {

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        runtimeService.startProcessInstanceByKey("quartz-demo-process");
    }
}