package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;

public class FactTest {

    @Test
    public void whenNLessThan0ThrowsEx() {
        Fact fact = new Fact();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
            fact.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }
}