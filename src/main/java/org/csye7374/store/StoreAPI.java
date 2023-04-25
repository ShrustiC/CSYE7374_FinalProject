package org.csye7374.store;

import org.csye7374.billing.PriceStrategyAPI;

import java.util.List;

public interface StoreAPI {
    public double sumTotal(List<Double> itemList);
    public void setStrategy(PriceStrategyAPI s);
    double getSum();
    String toStringSumTotal();
}
