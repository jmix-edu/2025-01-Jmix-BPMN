package com.company.jmixbpmdemo.app;

import io.netty.handler.timeout.ReadTimeoutException;
import org.flowable.engine.delegate.BpmnError;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component(value = "errorService")
public class ErrorService {

    private int FAIL_PROBABILITY = 50;

    public void probablyError(String code) {
        if (failure()) {
            System.out.println("Error code: " + code);
            throw new BpmnError(code);
        } else {
            System.out.println("Success!");
        }
    }

    private boolean failure() {
        Random random = new Random();
        int generated = random.nextInt(100);
        return generated < FAIL_PROBABILITY;
    }

    public void technicalError(String code, Boolean error) {
        if (error != null && !error) {
            return;
        } else {
            System.out.println("Technical error! " + code);
            throw new RuntimeException(code);
        }
    }
}