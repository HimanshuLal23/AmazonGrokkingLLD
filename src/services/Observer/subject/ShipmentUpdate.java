package services.Observer.subject;

import Model.OrderStatus;
import Model.User;
import services.Observer.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class ShipmentUpdate implements Subject{
    List<Observer> observerList;
    public ShipmentUpdate() {
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(User user, OrderStatus orderStatus) {
        for(Observer observer:observerList) {
            observer.update(user,orderStatus);
        }
    }
}
