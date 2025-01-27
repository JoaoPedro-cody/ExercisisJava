package exercise10.model.services;

import exercise10.model.entities.Contract;
import exercise10.model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){

        double valuePerPac = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate newDate = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(valuePerPac, i);
            double fee = onlinePaymentService.paymentFee(interest);

            contract.getInstallment().add(new Installment(newDate, fee));
        }
    }
}
