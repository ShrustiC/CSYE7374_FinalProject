package org.csye7374.Item;

public class GiftWrapDecorator extends ItemDecorator {

    public GiftWrapDecorator(ItemAPI item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return this.item.getPrice() + 3.49;
    }

    @Override
    public String getName() {
        return this.item.getName() + ", gift wrapped";
    }

}
