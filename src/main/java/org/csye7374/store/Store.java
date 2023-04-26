package org.csye7374.store;

import org.csye7374.billing.PriceStrategyAPI;
import org.csye7374.billing.ZeroDiscount;
import org.csye7374.utils.BasicCalculator;
import org.csye7374.utils.CalculatorAPI;

import java.util.ArrayList;
import java.util.List;

public class Store implements StoreAPI {
    private PriceStrategyAPI s = new ZeroDiscount();
    private List<Double> itemList = new ArrayList<>();
    private CalculatorAPI cal = new BasicCalculator();

    public Store(CalculatorAPI cal) {
        this.cal = cal;
    }

    @Override
    public double sumTotal(List<Double> itemList) {
        this.itemList = itemList;
        double t = 0.0;
        for (Double x: itemList) {
            t = cal.add(t, s.getDiscountedPrice(x));
        }
        return t;
    }

    @Override
    public void setStrategy(PriceStrategyAPI s) {
        this.s = s;
    }

    @Override
    public double getSum() {
        return this.sumTotal(this.itemList);
    }

    @Override
    public String toStringSumTotal() {
        return String.valueOf(getSum());
    }

    @Override
    public String toString() {
        return "Pos1{" +
                "itemList=" + itemList +
                ", cal=" + cal +
                ", Sum total=" + toStringSumTotal() +
                '}';
    }
}
