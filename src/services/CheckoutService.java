package services;

import Dao.OrderDao;
import Dao.ProductDao;
import Model.*;

import java.util.List;

public class CheckoutService {
    private OrderDao orderDao;
    private ProductDao productDao;
    public CheckoutService() {
        orderDao = OrderDao.getInstance();
        this.productDao = ProductDao.getInstance();
    }

    public Order checkOutAndCreateOrder(Cart cart, User user) {
        updateCartPrice(cart);
        double price = getCartPrice(cart);
        cart.setPrice(price);
        Order order = new Order(cart,cart.getPrice(),user.getId());
        orderDao.addOrder(order);
        return order;
    }

    private void updateCartPrice(Cart cart) {
        final List<Product> productList = productDao.getProductList();
        for(CartItem cartItem:cart.getProductList()) {
            for (var product : productList) {
                if(cartItem.getProductId().equals(product.getId())) {
                    cartItem.setPrice(product.getPrice());
                }
            }
        }
    }
    private double getCartPrice(Cart cart) {
        return cart.getProductList().stream().mapToDouble(x-> x.getQuantity()*x.getPrice()).sum();
    }
}
