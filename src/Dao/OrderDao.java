package Dao;

import Model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static List<Order> orderList;

    public OrderDao() {
        orderList = new ArrayList<>();
    }

    private static class Holder {
        private static OrderDao instance = new OrderDao();
    }

    public static OrderDao getInstance() {
        return Holder.instance;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }
    public List<Order> getOrderList() {
        return orderList;
    }
}
