package org.csye7374.Item;

import java.util.List;

public class InStockState implements State {
    @Override
    public boolean isItemAvailable(ItemAPI item, List<ItemAPI> items) {
        for (ItemAPI i : items) {
            if (i.getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }
}