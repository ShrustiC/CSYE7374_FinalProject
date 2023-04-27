package org.csye7374.Item;

import java.util.List;

public interface State {
    boolean isItemAvailable(ItemAPI item, List<ItemAPI> items);
}
