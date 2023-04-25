package org.csye7374.billing;

public interface PriceStrategyAPI {
    public Double getDiscountedPrice(Double originalPrice);
}
