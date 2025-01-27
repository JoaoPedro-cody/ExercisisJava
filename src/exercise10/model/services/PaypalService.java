package exercise10.model.services;

public class PaypalService implements OnlinePaymentService {

    @Override
    public Double paymentFee(Double amount) {
        double taxPayment = amount * 0.02;
        return  amount + taxPayment;
    }

    @Override
    public Double interest(Double amount, Integer month) {
        double taxPayment = amount * 0.01 * month;
        return  amount + taxPayment;
    }
}
