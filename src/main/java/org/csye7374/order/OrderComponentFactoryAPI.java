package org.csye7374.order;

public interface OrderComponentFactoryAPI {
    OrderComponentAPI getObject();
    OrderComponentAPI getObject(OrderBuilderAPI b);
}