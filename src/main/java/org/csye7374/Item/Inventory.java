package org.csye7374.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private State state;
    private List<Item> items;

    public Inventory() {
        state = new InStockState();
        items = new ArrayList<>();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
        if (!isItemAvailable(item)) {
            setState(new OutOfStockState());
        }
    }

    public boolean isItemAvailable(Item item) {
        return state.isItemAvailable(item, items);
    }

    public void setOutOfStockState() {
        state = new OutOfStockState();
    }
}
