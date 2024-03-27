package Model;

import java.util.UUID;

public class Payment {
    private UUID paymentId;
    private Address billingAddress;
    private PaymentType paymentType;
    private double price;
    private UUID orderId;
    private boolean success;

    public Payment(Address billingAddress, PaymentType paymentType, double price, UUID orderId, boolean success) {
        this.paymentId = UUID.randomUUID();
        this.billingAddress = billingAddress;
        this.paymentType = paymentType;
        this.price = price;
        this.orderId = orderId;
        this.success = success;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public double getPrice() {
        return price;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public boolean isSuccess() {
        return success;
    }
}
