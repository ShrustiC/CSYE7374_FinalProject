package org.csye7374.order;

import org.csye7374.Item.ItemAPI;

import java.util.ArrayList;
import java.util.List;

public class SingleStoreOrderBuilder implements OrderBuilderAPI {
    public String name = "";
    public List<ItemAPI> items = new ArrayList<>();
    @Override
    public OrderComponentAPI build() {
        return new SingleStoreOrder(this);
    }

    @Override
    public OrderBuilderAPI addItem(ItemAPI item) {
        items.add(item);
        return this;
    }

    @Override
    public OrderBuilderAPI setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + items.toString();
    }
}