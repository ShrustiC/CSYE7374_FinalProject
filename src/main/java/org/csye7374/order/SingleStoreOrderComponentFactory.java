package org.csye7374.order;

import org.csye7374.Item.ItemAPI;

import java.util.ArrayList;

public class SingleStoreOrderComponentFactory implements OrderComponentFactoryAPI {
    @Override
    public OrderComponentAPI getObject() {
        return new SingleStoreOrder(new ArrayList<ItemAPI>(), "");
    }

    @Override
    public OrderComponentAPI getObject(OrderBuilderAPI b) {
        return b.build();
    }
}