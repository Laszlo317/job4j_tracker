package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(el);
            }
            tmp.add(value);
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        DepDescComp comp = new DepDescComp();
        orgs.sort(comp);
    }

    public static void sortDesc(List<String> orgs) {
        DepDescComp comp = new DepDescComp();
        orgs.sort(comp.reversed());
    }
}
