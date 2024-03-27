package Dao;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static List<Product> productList;

    public ProductDao() {
        productList = new ArrayList<>();
    }

    private static class Holder {
        private static ProductDao instance = new ProductDao();
    }

    public static ProductDao getInstance() {
        return Holder.instance;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
    public List<Product> getProductList() {
        return productList;
    }
}
