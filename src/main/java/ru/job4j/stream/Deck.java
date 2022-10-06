package ru.job4j.stream;

import java.util.stream.Stream;

public class Deck {
    public static void main(String[] args) {
        Suit[] suits = {Suit.Hearts, Suit.Clubs, Suit.Spades, Suit.Diamonds};
        Value[] values = {Value.V_6, Value.V_7, Value.V_8};
        Stream.of(suits)
                .flatMap(suit -> Stream.of(values)
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}
