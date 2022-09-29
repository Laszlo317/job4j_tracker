package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean isGulped) {
        if (isGulped) {
            System.out.println("Oh no! They ate Ball!");
        } else {
            System.out.println("Phew...");
        }
    }

}
