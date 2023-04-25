package org.csye7374.billing;

public class SpecialDiscount implements PriceStrategyAPI {
    @Override
    public Double getDiscountedPrice(Double originalPrice) {
        return 0.8 * originalPrice;
    }
}
