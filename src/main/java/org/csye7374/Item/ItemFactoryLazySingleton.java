package org.csye7374.Item;

public class ItemFactoryLazySingleton implements ItemFactoryAPI {
    private static ItemFactoryLazySingleton instance = null;

    private ItemFactoryLazySingleton(){}

    public static synchronized ItemFactoryLazySingleton getInstance() {
        if (instance == null) {
            instance = new ItemFactoryLazySingleton();
        }
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