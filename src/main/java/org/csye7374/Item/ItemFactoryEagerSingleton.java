package org.csye7374.Item;

public class ItemFactoryEagerSingleton implements ItemFactoryAPI {
    private static ItemFactoryEagerSingleton instance = new ItemFactoryEagerSingleton();
    private ItemFactoryEagerSingleton(){}
    public static ItemFactoryEagerSingleton getInstance() {
        return instance;
    }

    @Override
    public ItemAPI getObject() {
        return new Item();
    }

    @Override
    public ItemAPI getObject(ItemBuilder b) {
        return b.build();
    }
}