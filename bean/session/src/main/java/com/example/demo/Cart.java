package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}
