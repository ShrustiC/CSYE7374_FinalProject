package org.csye7374.order;

import org.csye7374.Item.ItemAPI;

import java.util.ArrayList;
import java.util.List;

public class ComboOrderBuilder implements ComboOrderBuilderAPI {
    public List<OrderComponentAPI> orders = new ArrayList<>();
    public String name = "";

    @Override
    public ComboOrder build() {
        return new ComboOrder(this);
    }

    @Override
    public OrderBuilderAPI addItem(ItemAPI item) {
        // Item cannot be added in a combo order
        return this;
    }

    @Override
    public ComboOrderBuilderAPI setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ComboOrderBuilderAPI addOrder(OrderComponentAPI order) {
        this.orders.add(order);
        return this;
    }
}