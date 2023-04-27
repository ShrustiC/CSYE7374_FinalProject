package org.csye7374.Item;

import java.util.Map;

// method that will be called by the observable when a observer state changes
public interface ObserverAPI {
    void update(Map<ItemAPI, Double> discounts);
}
