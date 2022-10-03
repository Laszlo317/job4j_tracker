package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindByNameAction implements UserAction {

    private Output out;

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
        List<Item> item = tracker.findByName(name);
        if (!item.isEmpty()) {
            out.println(item.toString());
        } else {
            out.println("Заявок с таким именем " + name + " не найдено");
        }
        return true;
    }
}
