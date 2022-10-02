package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by ID ===");
        int id = input.askInt("Enter id");
        Item item = tracker.findById(id);
        out.println(item);
        return true;
    }
}
