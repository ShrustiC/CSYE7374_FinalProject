package org.csye7374.order;

import org.csye7374.Item.ItemAPI;

import java.util.ArrayList;
import java.util.List;

public class MultiStoreOrderBuilder implements MultiStoreOrderBuilderAPI {
    public List<OrderComponentAPI> orders = new ArrayList<>();
    public String name = "";

    @Override
    public MultiStoreOrder build() {
        return new MultiStoreOrder(this);
    }

    @Override
    public OrderBuilderAPI addItem(ItemAPI item) {
        // Item cannot be added in a combo order
        return this;
    }

    @Override
    public MultiStoreOrderBuilderAPI setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public MultiStoreOrderBuilderAPI addOrder(OrderComponentAPI order) {
        this.orders.add(order);
        return this;
    }
}