package services.product;

import Dao.ProductDao;
import Model.Category;
import Model.Product;
import Model.User;
import Model.UserType;

import Exception.*;

public class ProductUpdateService {
    private ProductDao productDao;

    public ProductUpdateService() {
        productDao = ProductDao.getInstance();
    }

    public void updateProductName(Product productToBeUpdated, User user, String name) throws AmazonException {
        if(!user.getUserType().equals(UserType.Admin)) {
            throw new AmazonException(ExceptionMessage.unauthorizedUpdateProductExceptionMessage,ExceptionType.UnauthorizedUserException);
        }
        for(Product product:productDao.getProductList()) {
            if(product.equals(productToBeUpdated)) {
                product.setName(name);
                return;
            }
        }
        throw new AmazonException(ExceptionMessage.productNotFoundExceptionMessage,ExceptionType.NoProductFoundException);
    }

    public void updateProductCategory(Product productToBeUpdated, User user, Category category) throws AmazonException {
        if(!user.getUserType().equals(UserType.Admin)) {
            throw new AmazonException(ExceptionMessage.unauthorizedUpdateProductExceptionMessage,ExceptionType.UnauthorizedUserException);
        }
        for(Product product:productDao.getProductList()) {
            if(product.equals(productToBeUpdated)) {
                product.setCategory(category);
                return;
            }
        }
        throw new AmazonException(ExceptionMessage.productNotFoundExceptionMessage,ExceptionType.NoProductFoundException);
    }

    public void updateProductPrice(Product productToBeUpdated, User user, double updatedPrice) throws AmazonException {
        if(!user.getUserType().equals(UserType.Admin)) {
            throw new AmazonException(ExceptionMessage.unauthorizedUpdateProductExceptionMessage,ExceptionType.UnauthorizedUserException);
        }
        for(Product product:productDao.getProductList()) {
            if(product.equals(productToBeUpdated)) {
                product.setPrice(updatedPrice);
                return;
            }
        }
        throw new AmazonException(ExceptionMessage.productNotFoundExceptionMessage,ExceptionType.NoProductFoundException);
    }

    public void updateProductDescription(Product productToBeUpdated, User user, String updatedDescription) throws AmazonException {
        if(!user.getUserType().equals(UserType.Admin)) {
            throw new AmazonException(ExceptionMessage.unauthorizedUpdateProductExceptionMessage,ExceptionType.UnauthorizedUserException);
        }
        for(Product product:productDao.getProductList()) {
            if(product.equals(productToBeUpdated)) {
                product.setDescription(updatedDescription);
                return;
            }
        }
        throw new AmazonException(ExceptionMessage.productNotFoundExceptionMessage,ExceptionType.NoProductFoundException);
    }
}
