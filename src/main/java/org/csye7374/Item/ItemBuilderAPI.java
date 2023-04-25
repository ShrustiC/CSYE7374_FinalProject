package org.csye7374.Item;

public interface ItemBuilderAPI {
    public ItemBuilderAPI setName(String name);
    public ItemBuilderAPI setPrice(Double price);

    public Item build();
}