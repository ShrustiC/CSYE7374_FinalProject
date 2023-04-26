package org.csye7374;

import org.csye7374.Item.Inventory;
import org.csye7374.Item.Item;

public class Driver {
    public static void main(String[] args) {
        System.out.println("App started ....");
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