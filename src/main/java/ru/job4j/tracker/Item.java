package ru.job4j.tracker;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Item {
    private int id;
    private String name;

    private LocalDateTime created = now();

    public Item() { }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}