package Model;

import java.util.UUID;

public class CartItem {
    private UUID productId;
    private int quantity;
    private double price;
    private UUID itemId;

    public CartItem(UUID productId, int quantity) {
        this.itemId = UUID.randomUUID();
        this.productId = productId;
        this.quantity = quantity;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
