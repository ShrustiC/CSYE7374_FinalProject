package org.csye7374.order;

import java.util.ArrayList;

public class MultiStoreOrderComponentFactory implements OrderComponentFactoryAPI {
    @Override
    public OrderComponentAPI getObject() {
        return new MultiStoreOrder(new ArrayList<OrderComponentAPI>(), "");
    }

    @Override
    public OrderComponentAPI getObject(OrderBuilderAPI b) {
        return b.build();
    }
}
