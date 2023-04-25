package org.csye7374.billing;

public class MemberDiscount implements PriceStrategyAPI {
    @Override
    public Double getDiscountedPrice(Double originalPrice) {
        return 0.9 * originalPrice;
    }
}