package ru.job4j.tracker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public Comparator<Item> reversed() {
        return Comparator.super.reversed();
    }

    public List<Item> sort(List<Item> items) {
        Collections.sort(items, reversed());
        return items;
    }
}
