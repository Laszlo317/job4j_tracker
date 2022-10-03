package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        if (!citizens.containsValue(citizen)) {
            citizens.put(citizen.getPassport(), citizen);
             return true;
        }
        return false;
    }

    public Citizen get(String passport) {
        if (!citizens.containsKey(passport)) {
            throw new IllegalArgumentException();
        }
        return citizens.get(passport);
    }
}