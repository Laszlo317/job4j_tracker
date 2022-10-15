package ru.job4j.bank;

import java.util.*;

/**
 * Класс реализует набор базовых операций с пользователями и картами.
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя, если такого пользователя ещё нет.
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод ищет пользователя по паспорту и закрепляет за ним Account, если соответствующий
     * аккаунт ещё за ним не закреплён. Бросает исколючение, если
     * @param passport паспорт, по которому ищется пользователь
     * @param account аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит User'a по паспарту, перебирая ключи карты users.
     * @param passport паспорт, по которому будет выполняться поиск
     * @return возвращает пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Используя метод finByPassport, находит пользователя и по передаваемому реквезиту
     * проверяет есть ли у него соотвутствующий аккаунт.
     * @param passport паспорт для метода findByPassport
     * @param requisite реквизиты искомого аккаунта
     * @return возвращает аккаунт или null, если аккаунт не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User u = findByPassport(passport);
        if (u != null) {
            return users.get(u)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Используя пасспорт и реквизиты отправителя и получателя, перебрасывает деньги. Выполняет проверку,
     * существуют ли подобные пользователи и реквезиты.
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквезиты отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквезиты отправителя
     * @param amount уоличество переводимых денег
     * @return возвращает true, если перевод выполнен успешно, в ином случае возвращает false.
     */
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

    /**
     * Возвращает лист всех аккаунтов, извлекая их иp карты users
     * @param user пользователь, аккаунты которого возвращаются
     * @return возвращает лист аккаунтов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}