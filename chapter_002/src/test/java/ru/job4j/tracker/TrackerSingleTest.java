package ru.job4j.tracker;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleTest {
    @Test
    public void whenCreateTrackerSingleEnum() {
        Tracker tracker = TrackerSingleEnum.INSTANCE.getTracker();
        Tracker trackerOther = TrackerSingleEnum.INSTANCE.getTracker();
        tracker.add(new Item("enum", "test"));
        List<Item> items = trackerOther.findByName("enum");
        assertThat("enum", is(items.get(0).getName()));
    }

    @Test
    public void whenCreateTrackerSingleLazy() {
        TrackerSingleLazy tracker = TrackerSingleLazy.getInstance();
        TrackerSingleLazy trackerOther = TrackerSingleLazy.getInstance();
        tracker.add(new Item("lazy", "test"));
        List<Item> items = trackerOther.findByName("lazy");
        assertThat("lazy", is(items.get(0).getName()));
    }

    @Test
    public void whenCreateTrackerSingleEager() {
        TrackerSingleEager tracker = TrackerSingleEager.getInstance();
        TrackerSingleEager trackerOther = TrackerSingleEager.getInstance();
        tracker.add(new Item("eager", "test"));
        List<Item> items = trackerOther.findByName("eager");
        assertThat("eager", is(items.get(0).getName()));
    }

    @Test
    public void whenCreateTrackerSingleNested() {
        TrackerSingleNested tracker = TrackerSingleNested.getInstance();
        TrackerSingleNested trackerOther = TrackerSingleNested.getInstance();
        tracker.add(new Item("nested", "test"));
        List<Item> items = trackerOther.findByName("nested");
        assertThat("nested", is(items.get(0).getName()));
    }

}
