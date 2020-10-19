package ru.netology.manager;

import ru.netology.domain.AfishaItem;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int itemMovie = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int itemMovie) {
        this.repository = repository;
        if (itemMovie >= 0) {
            this.itemMovie = itemMovie;
        }
    }

    public AfishaItem[] getLast() {
        AfishaItem[] items = repository.findAll();
        int count = items.length > itemMovie ? itemMovie : items.length;
        AfishaItem[] result = new AfishaItem[count];
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public AfishaItem[] getAll() {
        return repository.findAll();
    }

    public void add(AfishaItem item) {
        repository.save(item);
    }
}