package exercise10.app;

import exercise10.model.entities.Contract;
import exercise10.model.entities.Installment;
import exercise10.model.services.ContractService;
import exercise10.model.services.PaypalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Among the contract data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);
        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();
        System.out.print("Enter the number of installments: ");
        int install = sc.nextInt();

        Contract contract = new Contract(number, date, totalValue);
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, install);

        System.out.println("Installments");
        for (Installment installment : contract.getInstallment()){
            System.out.println(installment);
        }

    }
}
