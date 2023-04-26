package org.csye7374.billing;

public class ZeroDiscount implements PriceStrategyAPI {
    @Override
    public Double getDiscountedPrice(Double originalPrice) {
        return originalPrice;
    }
}
