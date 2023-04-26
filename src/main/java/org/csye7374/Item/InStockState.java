package org.csye7374.Item;

import java.util.List;

public class InStockState implements State {
    @Override
    public boolean isItemAvailable(Item item, List<Item> items) {
        for (Item i : items) {
            if (i.getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }
}