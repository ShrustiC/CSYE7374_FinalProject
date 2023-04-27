package org.csye7374.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private State state;
    private List<ItemAPI> items;

    public Inventory() {
        state = new InStockState();
        items = new ArrayList<>();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addItem(ItemAPI item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
        if (!isItemAvailable(item)) {
            setState(new OutOfStockState());
        }
    }

    public boolean isItemAvailable(ItemAPI item) {
        boolean flag= state.isItemAvailable(item, items);
        if(flag){
            System.out.println(item.getName() + " is available for purchase.");
        }else{
            System.out.println(item.getName() + " is out of stock.");
        }
        return flag;
    }

    public void setOutOfStockState() {
        state = new OutOfStockState();
    }
}
