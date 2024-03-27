package services.Observer.observers;

import Model.OrderStatus;
import Model.User;

public interface Observer {
    void update(User user, OrderStatus orderStatus);
}
