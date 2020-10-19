package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTest {
        private AfishaManager manager;
        private AfishaItem item1 = new AfishaItem(1, "name1", "http://", "action movie");
        private AfishaItem item2 = new AfishaItem(2, "name2", "http://", "cartoon");
        private AfishaItem item3 = new AfishaItem(3, "name3", "http://", "comedy");
        private AfishaItem item4 = new AfishaItem(4, "name4", "http://", "horror");
        private AfishaItem item5 = new AfishaItem(5, "name5", "http://", "action movie");
        private AfishaItem item6 = new AfishaItem(6, "name6", "http://", "cartoon");
        private AfishaItem item7 = new AfishaItem(7, "name7", "http://", "comedy");
        private AfishaItem item8 = new AfishaItem(8, "name8", "http://", "horror");
        private AfishaItem item9 = new AfishaItem(9, "name9", "http://", "action movie");
        private AfishaItem item10 = new AfishaItem(10, "name10", "http://", "cartoon");
        private AfishaItem item11 = new AfishaItem(11, "name11", "http://", "comedy");

        private void initialValues() {
            manager.add(item1);
            manager.add(item2);
            manager.add(item3);
            manager.add(item4);
            manager.add(item5);
            manager.add(item6);
            manager.add(item7);
            manager.add(item8);
            manager.add(item9);
            manager.add(item10);
            manager.add(item11);
        }

        @Test
        void shouldGetEqualTenthMovie() {
            manager = new AfishaManager(10);
            initialValues();
            AfishaItem[] expected = new AfishaItem[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
            AfishaItem[] actual = manager.getLast();

            assertArrayEquals(expected, actual);
        }

        @Test
        void shouldGetLessMovie() {
            manager = new AfishaManager(5);
            manager.add(item1);
            manager.add(item2);
            manager.add(item3);
            manager.add(item4);
            manager.add(item5);
            AfishaItem[] expected = new AfishaItem[]{item5, item4, item3, item2, item1};
            AfishaItem[] actual = manager.getLast();

            assertArrayEquals(expected, actual);
        }

        @Test
        void shouldGetLastMovie() {
            manager = new AfishaManager(3);
            initialValues();
            AfishaItem[] expected = new AfishaItem[]{item11, item10, item9};
            AfishaItem[] actual = manager.getLast();

            assertArrayEquals(expected, actual);
        }

        @Test
        void shouldGetZeroMovie() {
            manager = new AfishaManager(0);
            initialValues();
            AfishaItem[] expected = new AfishaItem[0];
            AfishaItem[] actual = manager.getLast();

            assertArrayEquals(expected, actual);
        }

        @Test
        void shouldGetBelowZeroMovie() {
            manager = new AfishaManager(-1);
            initialValues();
            AfishaItem[] expected = new AfishaItem[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
            AfishaItem[] actual = manager.getLast();

            assertArrayEquals(expected, actual);
        }

        @Test
        void ShouldAddMovie() {
            manager = new AfishaManager(1);
            initialValues();
            AfishaItem[] actual = manager.getAll();
            AfishaItem[] expected = new AfishaItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};

            assertArrayEquals(expected, actual);
        }
    }

