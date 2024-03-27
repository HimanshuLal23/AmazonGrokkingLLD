package services.Observer.subject;

import Model.OrderStatus;
import Model.User;
import services.Observer.observers.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(User user, OrderStatus orderStatus);
}
