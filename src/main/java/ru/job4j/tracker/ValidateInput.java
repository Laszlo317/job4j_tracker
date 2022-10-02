package ru.job4j.tracker;

import ru.job4j.ex.NegativeNumberException;

public class ValidateInput implements Input {

    private Input input;
    private Output output;

    public ValidateInput(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NegativeNumberException nne) {
                output.println("Please enter a positive number");
            } catch (NumberFormatException nfe) {
                output.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}