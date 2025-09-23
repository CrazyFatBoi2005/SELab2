package com.example.test;

import java.util.ArrayList;

public final class DataBase {
    private static final DataBase INSTANCE = new DataBase();
    public static DataBase getInstance() { return INSTANCE; }

    private final ArrayList<Items> items = new ArrayList<>();

    private DataBase() {
        items.add(new Items(1, "Item 1", "Description 1", 100.00));
        items.add(new Items(2, "Item 2", "Description 2", 200.00));
        items.add(new Items(3, "Item 3", "Description 3", 300.00));
        items.add(new Items(4, "Item 4", "Description 4", 400.00));
        items.add(new Items(5, "Item 5", "Description 5", 500.00));
        items.add(new Items(6, "Item 6", "Description 6", 600.00));
        items.add(new Items(7, "Item 7", "Description 7", 700.00));
        items.add(new Items(8, "Item 8", "Description 8", 800.00));
        items.add(new Items(9, "Item 9", "Description 9", 900.00));

    }
    public ArrayList<Items> getItems() {
        return new ArrayList<>(items);
    }

    public void addItem(Items item) {
        if (item.getId() == 0) item.setId(items.size() + 1);
        items.add(item);
    }
}