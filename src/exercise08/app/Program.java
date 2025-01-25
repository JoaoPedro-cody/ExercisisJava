package exercise08.app;

import exercise08.model.entities.Account;
import exercise08.model.exception.BusinessException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char resp;

        do {

            try {
                System.out.println("Enter account data");
                System.out.print("Number: ");
                int number = sc.nextInt();
                System.out.print("Holder: ");
                sc.nextLine();
                String holder = sc.nextLine();
                System.out.print("Initial Balance: ");
                double initialBalance = sc.nextDouble();
                System.out.print("Withdraw Limit: ");
                double withdrawLimit = sc.nextDouble();
                Account account = new Account(number, holder, initialBalance, withdrawLimit);

                System.out.println();
                System.out.print("Enter amount for withdraw: ");
                double amount = sc.nextDouble();
                account.withdraw(amount);

                System.out.println("New Balance = " + String.format("%.2f", account.getInitialBalance()));
            }
            catch (BusinessException e){
                System.out.println("Withdraw Error: " + e.getMessage());
            }
            catch (RuntimeException e){
                System.out.println("Unexpected Error!");
            }

            System.out.print("Do you want to access another account? (y/n)" );
            resp = sc.next().charAt(0);
        } while (resp == 'y' || resp == 'Y');

        sc.close();
    }
}
