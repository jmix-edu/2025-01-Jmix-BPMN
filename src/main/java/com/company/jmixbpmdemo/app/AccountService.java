package com.company.jmixbpmdemo.app;

import com.company.jmixbpmdemo.entity.Account;
import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

import static java.lang.Thread.sleep;

@Component
public class AccountService {

    public static final int MAX_DELAY = 1500;
    public static final int FAIL_PROBABILITY = 35;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private SystemAuthenticator authenticator;

    public boolean debit(String owner, Long amountToDebit
    ) {
        delay();
        if(failure()) return false;

        authenticator.begin();
        try {
            Account account = dataManager.load(Account.class)
                    .query("select a from Account a where a.owner = :owner")
                    .parameter("owner", owner)
                    .one();
            long newAmount = account.getAmount() - amountToDebit;
            if (newAmount < 0L) {
                System.out.println("ERROR: Can't debit account " + owner);
                return false;
            } else {
                account.setAmount(newAmount);
                dataManager.save(account);
                System.out.println("SUCCESS: Debit account " + owner + " by " + amountToDebit);
                return true;
            }
        } finally {
            authenticator.end();
        }
    }

    public boolean credit(String owner, Long amountToCredit) {
        delay();
        if(failure()) return false;

        authenticator.begin();
        try {
            Account account = dataManager.load(Account.class)
                    .query("select a from Account a where a.owner = :owner")
                    .parameter("owner", owner)
                    .one();
            long newAmount = account.getAmount() + amountToCredit;
            if (newAmount > 10000L) {
                System.out.println("ERROR: Can't credit account " + owner);
                return false;
            } else {
                account.setAmount(newAmount);
                dataManager.save(account);
                System.out.println("SUCCESS: Credit account " + owner + " by " + amountToCredit);
                return true;
            }
        } finally {
            authenticator.end();
        }
    }

    private void delay() {
        Random random = new Random();
        int mills = random.nextInt(MAX_DELAY);
        try {
            sleep(mills);
        } catch (InterruptedException ignored) {}
    }

    private boolean failure() {
        Random random = new Random();
        return random.nextInt(100) < FAIL_PROBABILITY;
    }
}