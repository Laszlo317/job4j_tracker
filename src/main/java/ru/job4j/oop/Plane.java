package ru.job4j.oop;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + " letit");
    }
}
