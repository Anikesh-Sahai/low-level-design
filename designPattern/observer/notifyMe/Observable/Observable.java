package Observable;

import Observer.NotificationAlertObserver;


public interface Observable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount(int newStocksAdded);
    public int getStockCount();
} 
