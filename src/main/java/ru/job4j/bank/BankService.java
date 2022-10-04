package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            throw new NullPointerException();
        }
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User soughtUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                 soughtUser = user;
            }
        }
        return soughtUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account soughtAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account acc : getAccounts(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    soughtAccount = acc;
                }
            }
        }
        return soughtAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account sender = findByRequisite(srcPassport, srcRequisite);
        Account receiver = findByRequisite(destPassport, destRequisite);
        if (sender != null && receiver != null) {
            double senderBalance = sender.getBalance();
            double receiverBalance = receiver.getBalance();
            if (sender.getBalance() >= amount) {
                receiver.setBalance(receiverBalance + amount);
                sender.setBalance(senderBalance - amount);
                rsl = true;
            }
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}