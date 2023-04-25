package org.csye7374.order;

import java.util.ArrayList;

public class ComboOrderComponentFactory implements OrderComponentFactoryAPI {
    @Override
    public OrderComponentAPI getObject() {
        return new ComboOrder(new ArrayList<OrderComponentAPI>(), "");
    }

    @Override
    public OrderComponentAPI getObject(OrderBuilderAPI b) {
        return b.build();
    }
}
