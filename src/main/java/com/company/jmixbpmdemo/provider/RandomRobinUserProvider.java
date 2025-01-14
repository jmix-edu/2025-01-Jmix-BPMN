package com.company.jmixbpmdemo.provider;

import com.company.jmixbpmdemo.entity.User;
import io.jmix.bpm.provider.UserProvider;
import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

@UserProvider(value = "RandomRobinUserProvider")
public class RandomRobinUserProvider {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private SystemAuthenticator authenticator;

    public String getUser() {
        authenticator.begin();
        try {
            List<User> accountants = dataManager.load(User.class)
                    .query("SELECT u from User u WHERE u.position = 'accountant'")
                    .list();
            int randomNumber = new Random().nextInt(accountants.size());
            return accountants.get(randomNumber).getUsername();
        } finally {
            authenticator.end();
        }
    }
}