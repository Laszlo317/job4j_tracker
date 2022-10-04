package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("Gml task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(-1);
    }

    @Test
    public void whenCompatorByAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("xxx", 0),
                new Job("aaa", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorCombined() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("film", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isLessThan(0);
    }
}