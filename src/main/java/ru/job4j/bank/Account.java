package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных для банковского аккаунта.
 */
public class Account {
    /**
     * Уникальный идентификатор банковского аккаунта.
     */
    private String requisite;
    /**
     * Количество денег на этом аккаунте.
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * @return возвращает реквизиты
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * утсанавливает реквизиты
     * @param requisite устанавливаемые реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * @param balance баланс, который мы хотим установаить
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает объекты Аккаунт на основании их реквезитов
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}