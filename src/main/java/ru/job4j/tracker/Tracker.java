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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index] != null) {
                if (items[index].getId() == id) {
                    rsl = index;
                    break;
                }
            }
        }
        return rsl;
    }

    public void replace(int id, Item item) {
        if (indexOf(id) != -1) {
            items[indexOf(id)].setName(item.getName());
        }
    }

    public boolean delete(int id) {
        if (id <= 0) {
            return false;
        }
        int index = indexOf(id);
        items[index] = null;
        int length = items.length -  index - 1;
        System.out.println(length);
        System.arraycopy(items, index + 1, items, index, length);
        items[items.length - 1] = null;
        return true;
    }
}