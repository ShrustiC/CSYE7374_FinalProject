package org.csye7374.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemPrototypeFactory {
    public enum ItemType {
        GROCERY_ITEM, ELECTRONIC_ITEM, APPAREL_ITEM
    }
    Map<ItemType, Item> itemMap;
    {
        itemMap = new HashMap<>();
        itemMap.put(ItemType.GROCERY_ITEM, new Item(0.0, "Grocery"));
        itemMap.put(ItemType.ELECTRONIC_ITEM, new Item(0.0, "Electronics"));
        itemMap.put(ItemType.APPAREL_ITEM, new Item(0.0, "Apparel"));
    }

    public Item getObject(ItemType type) {
        return (Item) itemMap.get(type).clone();
    }
}
