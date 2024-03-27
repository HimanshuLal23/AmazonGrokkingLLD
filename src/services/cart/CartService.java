package services.cart;

import Model.Cart;
import Model.CartItem;
import Model.User;

import Exception.*;
public interface CartService {
    default void addToCart(Cart cart, CartItem cartItem, User user) throws AmazonException {
        throw new AmazonException();
    }
    default void removeFromCart(Cart cart,CartItem cartItem, User user) throws AmazonException{
        throw new AmazonException();
    }
    default void updateQuantityForCart(Cart cart,CartItem cartItem, int quantiy, User user) throws AmazonException{
        throw new AmazonException();
    }
}
