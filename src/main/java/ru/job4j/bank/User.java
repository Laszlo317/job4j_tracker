package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель данных, хранящая в себе информацию о пользователе банка.
 */
public class User {
    /**
     * Уникальный идентификатор пользователся.
     */
    private String passport;
    /**
     * Имя пользователя.
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return возвращает паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport паспорт
     * устанавливает паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * возвращает имя пользователя
     * @return возвращает имя пльзователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * устанавливает имя пользователя
     * @param username имя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает объекты User на основании их пасспартов.
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}