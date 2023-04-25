package org.csye7374.Item;

public class ItemBuilder implements ItemBuilderAPI {
    public String name = "";
    public Double price = 0.0;
    @Override
    public ItemBuilderAPI setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ItemBuilderAPI setPrice(Double price) {
        this.price = price;
        return this;
    }

    @Override
    public Item build() {
        return new Item(this);
    }
}