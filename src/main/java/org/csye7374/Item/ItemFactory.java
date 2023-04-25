package org.csye7374.Item;

public class ItemFactory implements ItemFactoryAPI {
    @Override
    public ItemAPI getObject() {
        return new Item();
    }

    @Override
    public ItemAPI getObject(ItemBuilder b) {
        return (new ItemBuilder()).build();
    }
}