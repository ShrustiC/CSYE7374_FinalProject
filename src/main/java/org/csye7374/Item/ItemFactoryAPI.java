package org.csye7374.Item;

public interface ItemFactoryAPI {
    ItemAPI getObject();
    ItemAPI getObject(ItemBuilder b);
}
