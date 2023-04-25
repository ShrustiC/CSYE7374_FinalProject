package org.csye7374.Item;

public class ItemFactoryEnumSingleton {
    static private ItemFactoryEnumSingleton instance = new ItemFactoryEnumSingleton();

    public static ItemFactoryEnumSingleton getInstance() {
        return instance;
    }

    private ItemFactoryEnumSingleton(){}
    public ItemAPI getObject(ItemType type) {
        ItemBuilder builder = new ItemBuilder();
        Item item = builder.build();
        switch (type) {
            case PIZZA :
                item = builder.setName("pizza").setPrice(5.49).build();
                break;
            case SALAD:
                item = builder.setName("salad").setPrice(2.49).build();
                break;
            case BUFFALOWINGS:
                item = builder.setName("buffalo wings").setPrice(4.49).build();
                break;
            case CHEESEBURGER:
                item = builder.setName("cheese burger").setPrice(3.79).build();
                break;
            case HOTDOG:
                item = builder.setName("hot dog").setPrice(1.79).build();
                break;
            case HAMBURGER:
                item = builder.setName("ham burger").setPrice(3.79).build();
                break;
            case FRENCHFRIES:
                item = builder.setName("French Fries").setPrice(0.99).build();
                break;
        }
        return item;
    }
}
