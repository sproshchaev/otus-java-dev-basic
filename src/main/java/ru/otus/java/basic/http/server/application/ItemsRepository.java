package ru.otus.java.basic.http.server.application;

import ru.otus.java.basic.http.server.exceptions.BadRequestException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemsRepository {
    private List<Item> items;

    public ItemsRepository() {
        this.items = new ArrayList<>(Arrays.asList(
                new Item(1L, "Milk", BigDecimal.valueOf(92)),
                new Item(2L, "Bread", BigDecimal.valueOf(40)),
                new Item(3L, "Cheese", BigDecimal.valueOf(400))
        ));
    }

    public Item findById(Long id) {
        for (Item o : items) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }

    public List<Item> getAllItems() {
        return Collections.unmodifiableList(items);
    }

    public void addNewItem(Item item) {
        items.add(item);
    }
}
