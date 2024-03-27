package services;

import Model.*;

public class PaymentService {

    public Payment doPayment(Order order, User user, Address billingAddress, PaymentType paymentType) {
        Payment payment = new Payment(billingAddress,paymentType,order.getPrice(),order.getId(),true);
        return payment;
    }

    public Payment doPayment(Order order, User user, PaymentType paymentType) {
        Payment payment = new Payment(user.getDefaultAddress(),paymentType,order.getPrice(),order.getId(),true);
        return payment;
    }

}
