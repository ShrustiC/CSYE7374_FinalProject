package org.csye7374.Item;

import java.util.List;
import org.csye7374.Item.Item;

public class InventoryFacade {
    private InStockState inStockState;

    public InventoryFacade() {
        this.inStockState = new InStockState();
    }

    public boolean isItemAvailable(ItemAPI item, List<ItemAPI> items) {
        return inStockState.isItemAvailable(item, items);
    }
}
