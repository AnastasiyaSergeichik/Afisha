package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {

    @Mock
    private AfishaRepository repository;
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

    @Test
    void shouldGetEqualTenthMovie() {
        AfishaItem[] mockStub = new AfishaItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        doReturn(mockStub).when(repository).findAll();
        manager = new AfishaManager(repository, 10);
        AfishaItem[] expected = new AfishaItem[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldGetLessMovie() {
        AfishaItem[] mockStub = new AfishaItem[]{item1, item2, item3, item4, item5};
        doReturn(mockStub).when(repository).findAll();
        manager = new AfishaManager(repository);
        AfishaItem[] expected = new AfishaItem[]{item5, item4, item3, item2, item1};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldGetLastMovie() {
        AfishaItem[] mockStub = new AfishaItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        doReturn(mockStub).when(repository).findAll();
        manager = new AfishaManager(repository, 3);
        AfishaItem[] expected = new AfishaItem[]{item11, item10, item9};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldGetZeroMovie() {
        AfishaItem[] mockStub = new AfishaItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        doReturn(mockStub).when(repository).findAll();
        manager = new AfishaManager(repository, 0);
        AfishaItem[] expected = new AfishaItem[0];
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldGetBelowZeroMovie() {
        AfishaItem[] mockStub = new AfishaItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        doReturn(mockStub).when(repository).findAll();
        manager = new AfishaManager(repository, -1);
        AfishaItem[] expected = new AfishaItem[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        AfishaItem[] actual = manager.getLast();

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void ShouldAddMovie() {
        doNothing().when(repository).save(any(AfishaItem.class));
        manager = new AfishaManager(repository);
        manager.add(item1);
        manager.add(item2);

        verify(repository).save(item2);
        verify(repository).save(item1);
    }
}

