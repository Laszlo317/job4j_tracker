package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

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
        List<Item> item = tracker.findAll();
        if (!item.isEmpty()) {
            out.println(item.toString());
        } else {
            out.println("В списке пока нет заявок.");
        }
        return true;
    }
}
