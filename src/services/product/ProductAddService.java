package services.product;

import Dao.ProductDao;
import Model.Product;
import Model.User;
import Model.UserType;

import Exception.*;

public class ProductAddService {
    private ProductDao productDao;

    public ProductAddService() {
        productDao = ProductDao.getInstance();
    }

    public void addProduct(Product product, User user) throws AmazonException {
        if(!UserType.Admin.equals(user.getUserType())) {
            throw new AmazonException(ExceptionMessage.unauthorizedUpdateProductExceptionMessage, ExceptionType.UnauthorizedUserException);
        }
        productDao.addProduct(product);
    }

}
