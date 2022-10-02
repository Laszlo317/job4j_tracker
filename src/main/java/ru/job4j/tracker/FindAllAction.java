package ru.job4j.tracker;

import java.util.Arrays;

public class FindAllAction implements UserAction {

    private Output out;

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
        if (item.length != 0) {
            out.println(Arrays.toString(item));
        } else {
            out.println("В списке пока нет заявок.");
        }
        return true;
    }
}
