package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        int forecast = new Random().nextInt();
        switch (forecast) {
         case 1 ->
            System.out.println("Да");
         case 0 ->
            System.out.println("Нет");
         default ->
            System.out.println("Может быть");
        }
    }

}
