package services.Observer.observers;

import Model.OrderStatus;
import Model.User;

public class SMSObserver implements Observer{
    @Override
    public void update(User user, OrderStatus orderStatus) {
        System.out.println("Hey "+ user.getPhone()+" your order status has been updated"+orderStatus.name());
    }
}
