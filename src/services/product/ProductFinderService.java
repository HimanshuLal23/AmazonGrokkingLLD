package services.product;

import Dao.ProductDao;
import Model.Category;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductFinderService {
    private ProductDao productDao;
    private List<Product> productList;

    public ProductFinderService() {
        productDao = ProductDao.getInstance();
        productList = new ArrayList<>();
    }

    public List<Product> searchProductByName(String productName) {
        for(Product product:productList) {
            if(product.getName().equals(productName)) {
                productList.add(product);
            }
        }
        return productList;
    }

    public List<Product> searchProductByCategory(Category category) {
        for(Product product:productList) {
            if(product.getCategory().equals(category)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
