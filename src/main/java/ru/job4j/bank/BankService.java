package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (users.containsKey(user)) {
            throw new IllegalArgumentException("There is already a user registered by this name.");
        }
        users.put(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        for (Account acc : getAccounts(user)) {
            if (acc.getRequisite().equals(requisite)) {
                return acc;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account sender = findByRequisite(srcPassport, srcRequisite);
        Account receiver = findByRequisite(destPassport, destRequisite);
        if (sender == null || receiver == null) {
            return false;
        }
        double senderBalance = sender.getBalance();
        double receiverBalance = receiver.getBalance();
        if (sender.getBalance() >= amount) {
            receiver.setBalance(receiverBalance + amount);
            sender.setBalance(senderBalance - amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}