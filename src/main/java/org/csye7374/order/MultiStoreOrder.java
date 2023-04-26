package org.csye7374.order;

import java.util.ArrayList;
import java.util.List;

public class MultiStoreOrder implements OrderComponentAPI {
    private List<OrderComponentAPI> orders = new ArrayList<>();
    private String name = "";
    private int id = getId();

    public MultiStoreOrder(List<OrderComponentAPI> orders, String name) {
        this.orders = orders;
        this.name = name;
    }

    public MultiStoreOrder(MultiStoreOrderBuilder builder) {
        this.name = builder.name;
        this.orders = builder.orders;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (OrderAPI o: orders) {
            price += o.getPrice();
        }
        return price;
    }

    public MultiStoreOrder add(OrderComponentAPI child) {
        orders.add(child);
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        for (OrderComponentAPI o: orders) {
            sb.append(" {" + o.getDescription() + "} ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "MultiStoreOrder{" +
                "orders=" + orders +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}