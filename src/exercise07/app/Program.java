package exercise07.app;

import exercise07.ent.Company;
import exercise07.ent.Individual;
import exercise07.ent.Payers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Payers> payers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Tax payer #" + (i + 1) + " data:\n");
            System.out.print("Individual or company (i/c)? ");
            char letra = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();

            if (letra == 'i'){
                System.out.print("Health expenditures: ");
                Double healthExpend = sc.nextDouble();
                payers.add(new Individual(name, anualIncome, healthExpend));
            }else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                payers.add(new Company(name, anualIncome, numberOfEmployees));
            }

            sc.nextLine();
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        for (Payers j : payers){
            System.out.println(j.getName() + ": $ " + String.format("%.2f", j.tax()));
        }

        double sum = 0.0;
        for (Payers j : payers){
            sum += j.tax();
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f\n", sum);

        sc.close();
    }
}
