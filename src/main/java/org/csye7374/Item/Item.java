package org.csye7374.Item;

public class Item implements ItemAPI {
    protected double price = 0;
    protected String name = "";

    public Item() {
    }

    public Item(ItemBuilder builder) {
        this.name = builder.name;
        this.price = builder.price;
    }

    public Item(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        try {
            Item c = (Item) super.clone();
            c.setPrice(0.0);
            c.setName("");
            return c;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new Item();
    }
}