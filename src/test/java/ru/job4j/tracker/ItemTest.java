package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

public class ItemTest {

    @Test
    public void whenSortAscAndSecondIsBiggest() {
        Item item1 = new Item("a");
        Item item2 = new Item("d");
        Item item3 = new Item("c");
        List<Item> items = Arrays.asList(item1, item2, item3);
        ItemAscByName comparator = new ItemAscByName();
        List<Item> expected = Arrays.asList(item1, item3, item2);
        assertThat(comparator.sort(items)).isEqualTo(expected);
    }

    @Test
    public void whenSortDescAndFirstIsLowest() {
        Item item1 = new Item("a");
        Item item2 = new Item("d");
        Item item3 = new Item("c");
        List<Item> items = Arrays.asList(item1, item2, item3);
        ItemDescByName comparator = new ItemDescByName();
        List<Item> expected = Arrays.asList(item2, item3, item1);
        assertThat(comparator.sort(items)).isEqualTo(expected);
    }
}