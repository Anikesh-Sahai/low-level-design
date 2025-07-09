package Observer;

import Observable.Observable;

public class EmailNotificationAlert implements NotificationAlertObserver {
    String emailId;
    Observable observable;

    public EmailNotificationAlert(String emailId, Observable observable){
        this.emailId = emailId;
        this.observable = observable;   
    }

    @Override
    public void update(){
        sendEmail(emailId,"product is in stock");
    }
 
    public void sendEmail(String emailId, String msg){
        System.out.println("mail sent: "+ emailId);
        System.out.println("msg sent: "+ msg);
    }
}
