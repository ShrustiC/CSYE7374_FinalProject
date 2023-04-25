package org.csye7374.order;

import org.csye7374.Item.ItemAPI;

public interface OrderBuilderAPI {
    public OrderComponentAPI build();
    public OrderBuilderAPI addItem(ItemAPI item);
    public OrderBuilderAPI setName(String name);
}