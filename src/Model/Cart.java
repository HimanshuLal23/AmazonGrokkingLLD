package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private List<CartItem> itemList;
    private UUID id;
    private double price;

    public Cart() {
        itemList = new ArrayList<>();
    }

    public List<CartItem> getProductList() {
        return itemList;
    }

    public void addProduct(CartItem cartItem) {
        this.itemList.add(cartItem);
    }

    public void removeProduct(CartItem cartItem) {
        this.itemList.remove(cartItem);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
