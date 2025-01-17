package com.company.jmixbpmdemo.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class TechError implements JavaDelegate {

    private int errorCounter;

    @Override
    public void execute(DelegateExecution execution) {
        String responseCode = (String) execution.getVariable("responseCode");

        if (!"200".equals(responseCode)) {
            throw new RuntimeException("technical_error: " + errorCounter++);
        }
    }
}