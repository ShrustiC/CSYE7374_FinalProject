package org.csye7374.Item;

public abstract class ItemDecorator implements ItemAPI {
    protected ItemAPI item;
    public ItemDecorator(ItemAPI item) {
        this.item = item;
    }
    @Override
    public double getPrice() {
        return 0;
    }
    @Override
    public String getName() {
        return "";
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}
