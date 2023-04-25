package org.csye7374.order;

import org.csye7374.Item.ItemAPI;

import java.util.ArrayList;

public class IndividualOrderComponentFactory implements OrderComponentFactoryAPI {
    @Override
    public OrderComponentAPI getObject() {
        return new IndividualOrder(new ArrayList<ItemAPI>(), "");
    }

    @Override
    public OrderComponentAPI getObject(OrderBuilderAPI b) {
        return b.build();
    }
}