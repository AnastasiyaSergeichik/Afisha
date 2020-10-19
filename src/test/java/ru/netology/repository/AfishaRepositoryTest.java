package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
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

    @BeforeEach
    public void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        repository.save(item7);
        repository.save(item8);
        repository.save(item9);
        repository.save(item10);
        repository.save(item11);
    }

    @Test
    void shouldFindAllAndSaveMovie() {
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdMovie() {
        AfishaItem actual = repository.findById(2);
        AfishaItem expected = item2;
        assertEquals(expected, actual);
    }


    @Test
    void shouldNotFindByIdMovie() {
        AfishaItem actual = repository.findById(12);
        assertNull(actual);
    }

    @Test
    void removeByIdMovie() {
        repository.removeById(3);
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[]{item1, item2, item4, item5, item6, item7, item8, item9, item10, item11};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAllMovie() {
        repository.removeAll();
        AfishaItem[] actual = repository.findAll();
        AfishaItem[] expected = new AfishaItem[0];
        assertArrayEquals(expected, actual);
    }
}

