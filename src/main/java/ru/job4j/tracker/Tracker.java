package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[100];
        size = 0;
        for (Item item : items) {
            if (item != null) {
                rsl[size++] = item;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item[] findByName(String name) {
        Item[] rsl = new Item[100];
        size = 0;
        for (Item item : items) {
            if (item != null) {
                if (item.getName().equals(name)) {
                    rsl[size++] = item;
                }
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}