package org.csye7374.order;

import org.csye7374.Item.ItemAPI;
import org.csye7374.utils.Utils;

import java.util.List;

public class OrderAdapter implements OrderAPI {
    protected List<ItemAPI> items;
    protected Integer id;
    protected String name;

    public OrderAdapter(List<ItemAPI> items, String name) {
        this.name = name;
        this.items = items;
        id = Utils.getID();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getPrice() {
        double price = 0.0;
        for (ItemAPI i: items) {
            price += i.getPrice();
        }
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return id + " " + getPrice() + " " + name +  ".";
    }
}