package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends Pizza {
    public String name() {
        return super.name() + " with extra cheese and extra tomato";
    }
}
