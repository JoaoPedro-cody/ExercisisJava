package exercise09.model.services;

import exercise09.model.entities.CarRental;
import exercise09.model.entities.Invoice;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double priceperDay;

    private BrazilTaxService brazilTaxService;

    public RentalService(Double pricePerHour, Double priceperDay, BrazilTaxService brazilTaxService) {
        this.pricePerHour = pricePerHour;
        this.priceperDay = priceperDay;
        this.brazilTaxService = brazilTaxService;
    }

    public void processInvoice(CarRental carRental){

        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60;

        double basicPayment;
        if (hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours);
        }
        else {
            basicPayment = priceperDay * Math.ceil(hours / 24);
        }

        double tax = brazilTaxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

}
