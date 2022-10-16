package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl;
        String[] s1 = o1.split("/");
        String[] s2 = o2.split("/");
        int length = Math.min(s1.length, s2.length);
        rsl = s2[0].compareTo(s1[0]);
        if (rsl == 0) {
            for (int i = 0; i < length; i++) {
                rsl = s1[i].compareTo(s2[i]);
                if (rsl != 0) {
                    break;
                }
            }
            if (s2.length > s1.length) {
                rsl = -1;
            }
        }
        return rsl;
    }
}
