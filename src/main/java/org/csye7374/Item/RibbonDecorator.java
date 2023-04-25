package org.csye7374.Item;

public class RibbonDecorator extends ItemDecorator {
    public RibbonDecorator(ItemAPI item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return this.item.getPrice() + 1.99;
    }

    @Override
    public String getName() {
        return this.item.getName() + ", with ribbon";
    }
}
