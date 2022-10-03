package ru.job4j.collection;

import ru.job4j.search.Person;

import java.util.HashMap;
import java.util.HashSet;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> person = new HashMap<>();
        person.put("askjdfhj@mail.ru", "Vasiliy Menshikov");
        person.put("somedfjsk@mail.ru", "Grigoriy Molchanov");
        for (String email : person.keySet()) {
            System.out.println("Email: " + email + " | Name: " + person.get(email));
        }
    }
}
