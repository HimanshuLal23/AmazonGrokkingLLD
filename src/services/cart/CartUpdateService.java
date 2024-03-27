package services.cart;

import Dao.ProductDao;
import Model.Cart;
import Model.CartItem;
import Model.User;
import Model.UserType;

import Exception.*;

public class CartUpdateService implements CartService {
    private ProductDao productDao;

    public CartUpdateService() {
        productDao = ProductDao.getInstance();
    }

    public void updateQuantityForCart(Cart cart, CartItem cartItem, int quantity, User user) throws AmazonException {
        if(!UserType.Member.equals(user.getUserType())) {
            throw new AmazonException(ExceptionMessage.unauthorizedCartExceptionMessage, ExceptionType.UnauthorizedUserException);
        }
        if(!cart.getProductList().contains(cartItem)) {
            throw new AmazonException(ExceptionMessage.productNotFoundInCartExceptionMessage, ExceptionType.NoProductFoundException);
        }
        for(var product:productDao.getProductList()) {
            if(product.getId().equals(cartItem.getProductId())) {
                if(product.getQuantity() < cartItem.getQuantity() + quantity) {
                    throw new AmazonException(ExceptionMessage.productQuantityExceeded,ExceptionType.DesiredProductQuantityNotAvailableException);
                }else {
                    product.setQuantity(product.getQuantity() - (cartItem.getQuantity() + quantity));
                }
            }
        }
        cartItem.setQuantity(quantity);
        cart.addProduct(cartItem);
    }
}
