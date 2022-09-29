package ru.job4j.pojo;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student egor = new Student();
        egor.setName("Egor");
        egor.setGroup("IP-11");
        egor.setDate(LocalDateTime.now());
        System.out.println(egor.getName() + ". Group " + egor.getGroup() + ", entered on "
        + egor.getDate());
    }
}
