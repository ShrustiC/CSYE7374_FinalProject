package org.csye7374.Customer;

import org.csye7374.Item.ItemAPI;
import org.csye7374.Item.ObserverAPI;

import java.util.Map;

//customers implements update to receive notification for discounts
public class Customer implements ObserverAPI {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Map<ItemAPI, Double> discounts) {
        if(discounts == null || discounts.isEmpty()){
            System.out.println("Hello " + name + ", we'll get back with more offers soon!");
        }else{
            System.out.println("Hello " + name + ", the following items have been discounted :");
            for (Map.Entry<ItemAPI, Double> entry : discounts.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue() + "% off");
            }
        }

    }
}
