package ru.job4j.tracker;

import java.util.Arrays;

public class FindAllAction implements UserAction {

    Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find all ===");
        Item[] item = tracker.findAll();
        out.println(Arrays.toString(item));
        return true;
    }
}
