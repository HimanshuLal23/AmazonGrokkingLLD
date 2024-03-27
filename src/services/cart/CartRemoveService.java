package services.cart;

import Model.Cart;
import Model.CartItem;
import Model.User;
import Model.UserType;

import Exception.*;

public class CartRemoveService implements CartService {
    public void removeFromCart(Cart cart, CartItem cartItem, User user) throws AmazonException {
        if(!UserType.Member.equals(user.getUserType())) {
            throw new AmazonException(ExceptionMessage.unauthorizedCartExceptionMessage, ExceptionType.UnauthorizedUserException);
        }
        if(!cart.getProductList().contains(cartItem)) {
            throw new AmazonException(ExceptionMessage.productNotFoundInCartExceptionMessage, ExceptionType.NoProductFoundException);
        }
        cart.removeProduct(cartItem);
    }
}
