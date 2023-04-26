package org.csye7374.Item;

import java.util.List;

public class OutOfStockState implements State {
    @Override
    public boolean isItemAvailable(Item item, List<Item> items) {
        return false;
    }
}