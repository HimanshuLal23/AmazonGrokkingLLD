package Model;

import java.util.UUID;

public class Order {
    private UUID id;
    private Cart cart;
    private UUID userId;
    private double price;

    public Order(Cart cart,double price,UUID userId) {
        this.id = UUID.randomUUID();
        this.cart = cart;
        this.userId = userId;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }
}
