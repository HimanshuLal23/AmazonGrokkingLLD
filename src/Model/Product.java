package Model;

import java.util.UUID;

public class Product {
    private UUID id;
    private double price;
    private String name;
    private String description;
    private double review;
    private static int reviewCount;
    private Category category;
    private int quantity;

    public Product(double price, String name, String description, int quantity, Category category) {
        this.id = UUID.randomUUID();
        this.price = price;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
        reviewCount = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        reviewCount++;
        this.review = (review/reviewCount*1.0);
    }

    public Category getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void setReviewCount(int reviewCount) {
        Product.reviewCount = reviewCount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
