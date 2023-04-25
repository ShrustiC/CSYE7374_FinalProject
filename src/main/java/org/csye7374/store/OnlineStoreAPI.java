package org.csye7374.store;

public interface OnlineStoreAPI extends StoreAPI {
    public double getChange(Double cash);
    public String toStringCash();
    public String toStringChange();
}
