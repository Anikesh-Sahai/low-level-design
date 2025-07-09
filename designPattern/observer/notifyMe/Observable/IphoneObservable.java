package Observable;

import Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements Observable {
    public List<NotificationAlertObserver> observersList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer){ observersList.add(observer); }

    @Override
    public void remove(NotificationAlertObserver observer){ observersList.remove(observer); }

    @Override
    public void notifySubscribers(){
        for (NotificationAlertObserver observer : observersList) {
            observer.update();
        }
    }

    public void setStockCount(int newStocksAdded){
        if(stockCount == 0) notifySubscribers();
        stockCount = stockCount + newStocksAdded;
    }

    public int getStockCount() {return stockCount;}
}
