package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            String[] s = value.split("/");
            for (int i = 0; i < s.length; i++) {
                if (i == 1) {
                    start += "/";
                }
                start += s[i];
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        DepDescComp comp = new DepDescComp();
        orgs.sort(comp);
    }
}
