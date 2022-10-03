package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public final class SingleTracker {

    private static Tracker tracker = null;

    public static Tracker getInstance() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}