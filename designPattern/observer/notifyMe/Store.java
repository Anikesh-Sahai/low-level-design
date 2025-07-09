import Observable.IphoneObservable;
import Observable.Observable;
import Observer.EmailNotificationAlert;
import Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        Observable iphone = new IphoneObservable();

        NotificationAlertObserver observer1 = new EmailNotificationAlert("xyz@gmail.com", iphone);
        NotificationAlertObserver observer2 = new EmailNotificationAlert("xyz2@gmail.com", iphone);

        iphone.add(observer1);
        iphone.add(observer2);
        iphone.setStockCount(10);
    }
}
