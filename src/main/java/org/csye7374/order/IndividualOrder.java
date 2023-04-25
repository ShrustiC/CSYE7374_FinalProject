package org.csye7374.order;

import org.csye7374.Item.ItemAPI;

import java.util.List;

public class IndividualOrder extends OrderAdapter implements OrderComponentAPI {

    public IndividualOrder(List<ItemAPI> items, String name) {
        super(items, name);
    }

    public IndividualOrder(IndividualOrderBuilder builder) {
        super(builder.items, builder.name);
    }

    @Override
    public String getDescription() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ItemAPI i: items) {
            sb.append(" {" + i.toString() + "}, ");
        }
        return super.toString() + sb.toString();
    }


}