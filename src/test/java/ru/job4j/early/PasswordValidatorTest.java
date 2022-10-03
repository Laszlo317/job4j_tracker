package ru.job4j.early;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class PasswordValidatorTest {

    @Test
    public void onlyLowerCase() {
        PasswordValidator pv = new PasswordValidator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    pv.validate("nico nico douga");
                });
    }

    @Test
    public void withoutLowerCase() {
        PasswordValidator pv = new PasswordValidator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    pv.validate("HUMBL3D!");
                });
    }

    @Test
    public void doesntHaveNumbers() {
        PasswordValidator pv = new PasswordValidator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    pv.validate("By the task");
                });
    }

    @Test
    public void doesntHaveSpecialSymbols() {
        PasswordValidator pv = new PasswordValidator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    pv.validate("Bythetask5");
                });
    }

    @Test
    public void everythingInPlace() {
        PasswordValidator pv = new PasswordValidator();
        String input = "Be4oreUs!";
        String result = pv.validate(input);
        assertThat(result).isEqualTo(input);
    }

    @Test
    public void containsStopWord() {
        PasswordValidator pv = new PasswordValidator();
        String input = "Be4oreUs!admin";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    pv.validate(input);
                });
    }
}