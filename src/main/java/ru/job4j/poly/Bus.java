package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("The bus is setting off...");
    }

    @Override
    public void passengers(int amount) {
        System.out.println(amount + " passengers got on the bus");
    }

    @Override
    public int refuel(int amount) {
        return amount * 5;
    }
}
