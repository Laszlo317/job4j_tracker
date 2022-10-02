package ru.job4j.tracker;

import java.util.Arrays;

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
        Item[] item = tracker.findByName(name);
        if (item.length != 0) {
            out.println(Arrays.toString(item));
        } else {
            out.println("Заявок с таким именем " + name + " не найдено");
        }
        return true;
    }
}
