package org.csye7374.Item;

//interface to define methods to add, remove, notify observers of a change
public interface ObservableAPI {
    void register(ObserverAPI observer);
    void unregister(ObserverAPI observer);
    void notifyObservers();
}
