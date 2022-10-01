package ru.job4j.tracker;

import java.util.Arrays;

public class FindByNameAction implements UserAction {

    Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by name ===");
        String name = input.askStr("Enter name");
        Item[] item = tracker.findByName(name);
        out.println(Arrays.toString(item));
        return true;
    }
}
