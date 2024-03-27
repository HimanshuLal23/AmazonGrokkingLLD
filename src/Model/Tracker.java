package Model;

import java.util.UUID;

public class Tracker {
    private UUID orderId;
    private OrderStatus orderStatus;
    private UUID trackerId;

    public Tracker(UUID orderId, OrderStatus orderStatus) {
        this.trackerId = UUID.randomUUID();
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public UUID getTrackerId() {
        return trackerId;
    }
}
