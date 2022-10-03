package ru.job4j.search;

import java.util.ArrayList;
import java.util.Iterator;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Iterator<Person> it = persons.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            if (person.getPhone().contains(key) || person.getName().contains(key)
                    || person.getSurname().contains(key) || person.getAddress().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}