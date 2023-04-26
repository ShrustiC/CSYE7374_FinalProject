package org.csye7374.order;

import org.csye7374.Item.ItemAPI;

import java.util.List;

public class SingleStoreOrder extends OrderAdapter implements OrderComponentAPI {

    public SingleStoreOrder(List<ItemAPI> items, String name) {
        super(items, name);
    }

    public SingleStoreOrder(SingleStoreOrderBuilder builder) {
        super(builder.items, builder.name);
    }

    @Override
    public String getDescription() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{name = " + getName() + ", items = [");
        for (ItemAPI i: items) {
            sb.append(" {" + i.toString() + "}, ");
        }
        sb.append("] }");
        return super.toString() + sb.toString();
    }


}