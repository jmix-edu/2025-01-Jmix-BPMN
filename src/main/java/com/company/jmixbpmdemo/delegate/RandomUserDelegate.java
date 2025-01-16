package com.company.jmixbpmdemo.delegate;

import com.company.jmixbpmdemo.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RandomUserDelegate implements JavaDelegate {

    private final SystemAuthenticator systemAuthenticator;
    private final DataManager dataManager;

    public RandomUserDelegate(SystemAuthenticator systemAuthenticator, DataManager dataManager) {
        this.systemAuthenticator = systemAuthenticator;
        this.dataManager = dataManager;
    }

    @Override
    public void execute(DelegateExecution execution) {
        List<User> userList;
        Long randomIndex = (Long) execution.getVariable("randomIndex");
        systemAuthenticator.begin();

        try {
            userList = dataManager.load(User.class).all().list();
        } finally {
            systemAuthenticator.end();
        }

        String randomUsername = userList.get(Math.toIntExact(randomIndex))
                .getUsername().toUpperCase();

        String currentMessage = (String) execution.getVariable("message");
        execution.setVariable("message", randomUsername + ", " + currentMessage);

        System.out.println("Service task: " + execution.getCurrentActivityId() +  randomUsername + ", " + currentMessage);



    }
}