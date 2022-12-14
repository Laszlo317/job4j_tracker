package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new CreateAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("item name");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new DeleteAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Replaced Item");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "Sanctuary", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new ReplaceAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Sanctuary");
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                + "Exiting..." + System.lineSeparator());
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new ReplaceAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "???????????? ???????????????? ??????????????." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "Exiting..." + ln
        );
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new FindByIdAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find by ID" + ln
                        + "1. Exit" + ln
                        + "=== Find by ID ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find by ID" + ln
                        + "1. Exit" + ln
                        + "Exiting..." + ln
        );
    }

    @Test
    public void whenFindAllTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new FindAllAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find all" + ln
                        + "1. Exit" + ln
                        + "=== Find all ===" + ln
                        + tracker.findAll().toString() + ln
                        + "Menu:" + ln
                        + "0. Find all" + ln
                        + "1. Exit" + ln
                        + "Exiting..." + ln
        );
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", one.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new FindByNameAction(out), new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find by name" + ln
                        + "1. Exit" + ln
                        + "=== Find by name ===" + ln
                        + tracker.findAll().toString() + ln
                        + "Menu:" + ln
                        + "0. Find by name" + ln
                        + "1. Exit" + ln
                        + "Exiting..." + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"5", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit" + ln
                        + "Exiting..." + ln
        );
    }

}