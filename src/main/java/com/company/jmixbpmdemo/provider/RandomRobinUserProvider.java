package com.company.jmixbpmdemo.provider;

import com.company.jmixbpmdemo.entity.User;
import io.jmix.bpm.provider.UserProvider;
import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

@UserProvider(value = "randomRobinUserProvider")
public class RandomRobinUserProvider {
    private static final Logger log = LoggerFactory.getLogger(RandomRobinUserProvider.class);

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
            String selectedUsername = accountants.get(randomNumber).getUsername();

            log.info("Assigned accountant: {}", selectedUsername);

            return selectedUsername;
        } finally {
            authenticator.end();
        }
    }
}