package org.csye7374.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//class maintains a list of observers
public class DiscountsAndOffers implements ObservableAPI{

    private List<ObserverAPI> observers;
    private Map<ItemAPI, Double> discounts;

    public DiscountsAndOffers() {
        observers = new ArrayList<>();
        discounts = new HashMap<>();
    }

    public void addDiscount(ItemAPI item, double discount) {
            discounts.put(item, discount);
            notifyObservers();
    }

    public void removeDiscount(ItemAPI item) {
        discounts.remove(item);
        notifyObservers();
    }

    @Override
    public void register(ObserverAPI observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(ObserverAPI observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ObserverAPI observer : observers) {
            observer.update(discounts);
        }
    }
}
