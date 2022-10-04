package ru.job4j.map;

public record Subject(String name, int score) {
    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int score() {
        return score;
    }
}