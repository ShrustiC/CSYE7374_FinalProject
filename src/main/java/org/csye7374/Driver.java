package org.csye7374;

import org.csye7374.Item.*;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        System.out.println("App started ....");
        demoState();
        demoItemSingletonFactoryAndBuilder();
        System.out.println("App exit ....");
    }

    private static void demoState() {
        System.out.println("-----------------------State-----------------------");
        //State Pattern change the State if Item is not available
        Item item = new Item( 10.99,"book");
        Item item1= new Item( 10.99,"pen");

        Inventory inventory = new Inventory();

        inventory.addItem(item);

        if (inventory.isItemAvailable(item1)) {
            System.out.println(item1.getName() + " is available for purchase.");
        } else {
            System.out.println(item1.getName() + " is out of stock.");
        }
        System.out.println("-----------------------END-----------------------");
    }

    private static void demoItemSingletonFactoryAndBuilder() {
        System.out.println("-----------------------Factory, Singleton and Builder-----------------------");
        List<ItemAPI> items = new ArrayList<>();
        ItemBuilder builder = new ItemBuilder();
        builder.setName("Apple (x6)").setPrice(3.99);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Eggs 18").setPrice(5.49);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Gatorade (x6)").setPrice(8.49);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        builder.setName("Chocolate Box").setPrice(10.0);
        items.add(ItemFactoryEagerSingleton.getInstance().getObject(builder));
        items.stream().forEach(i -> {System.out.println(i);});
        System.out.println("-----------------------END-----------------------");
    }
}

/*
facade --
state -- check order state
command -- we will skip
prototype
observer --
*/

// Item enum check them

//item types need to check