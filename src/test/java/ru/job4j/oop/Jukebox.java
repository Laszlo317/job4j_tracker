package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else
            System.out.println("Песня не найдена");
    }

    public static void main(String[] args) {
        Jukebox uselessJuke = new Jukebox();
        uselessJuke.music(1);
        uselessJuke.music(2);
        uselessJuke.music(3);
    }
}
