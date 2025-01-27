package exercise09.app;

import exercise09.model.entities.CarRental;
import exercise09.model.entities.Vehicle;
import exercise09.model.services.BrazilTaxService;
import exercise09.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter the rental data");
        System.out.print("Car Model: ");
        String model = sc.nextLine();
        System.out.print("Removal (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental carRental = new CarRental(start, finish, new Vehicle(model));

        System.out.print("Enter the price per hour: ");
        Double perHour = sc.nextDouble();
        System.out.print("Enter the price per day: ");
        Double perDay = sc.nextDouble();

        RentalService rentalService = new RentalService(perHour, perDay, new BrazilTaxService());
        rentalService.processInvoice(carRental);

        System.out.println("Invoice: ");
        System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));



        sc.close();
    }
}
