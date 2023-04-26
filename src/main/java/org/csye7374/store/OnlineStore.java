package org.csye7374.store;

import org.csye7374.billing.PriceStrategyAPI;
import org.csye7374.billing.ZeroDiscount;
import org.csye7374.utils.AdvancedCalculatorAPI;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore implements OnlineStoreAPI {
    private PriceStrategyAPI s = new ZeroDiscount();
    private List<Double> itemList = new ArrayList<>();
    private AdvancedCalculatorAPI cal;

    private Double cash = 0.0;

    public OnlineStore(AdvancedCalculatorAPI cal) {
        this.cal = cal;
    }

    @Override
    public double getChange(Double cash) {
        this.cash = cash;
        return cash - getSum();
    }

    @Override
    public String toStringCash() {
        return "Cash: " + cash;
    }

    @Override
    public String toStringChange() {
        if (cash > getSum()) {
            return "Change: " + getChange(cash);
        }
        return "Change: 0.0";
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
        return "Pos2{" +
                "Sum total=" + toStringSumTotal() +
                '}';
    }
}
