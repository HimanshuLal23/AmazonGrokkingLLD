package services.cart;

import Dao.ProductDao;
import Model.Cart;
import Model.CartItem;
import Model.User;
import Model.UserType;

import Exception.*;

public class CartAddService implements CartService {
    private ProductDao productDao;

    public CartAddService() {
        productDao = ProductDao.getInstance();
    }

    public void addToCart(Cart cart, CartItem cartItem, User user) throws AmazonException {
        if(!UserType.Member.equals(user.getUserType())) {
            throw new AmazonException(ExceptionMessage.unauthorizedCartExceptionMessage,ExceptionType.UnauthorizedUserException);
        }
        for(var product:productDao.getProductList()) {
            if(product.getId().equals(cartItem.getProductId())) {
                if(product.getQuantity()< cartItem.getQuantity()) {
                    throw new AmazonException(ExceptionMessage.productQuantityExceeded,ExceptionType.DesiredProductQuantityNotAvailableException);
                }else {
                    product.setQuantity(product.getQuantity()- cartItem.getQuantity());
                }
            }
        }
        cart.addProduct(cartItem);
    }

}
