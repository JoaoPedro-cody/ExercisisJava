package exercise11.app;

import exercise11.model.services.BrazilInterestService;

import java.util.Scanner;

public class Program {

        public static <InterestService> void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            System.out.print("Months: ");
            int months = sc.nextInt();

            BrazilInterestService is = new BrazilInterestService(2.0);
            double payment = is.payment(amount, months);

            System.out.println("Payment after " + months + " months:");
            System.out.println(String.format("%.2f", payment));

            sc.close();
        }

}
