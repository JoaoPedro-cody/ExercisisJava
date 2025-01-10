package exercise04.application;

import exercise04.entities.Employee;
import exercise04.entities.OutSourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + " data:");
            System.out.print("Outsourced (y/n)? ");
            sc.nextLine();
            char yN = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            Integer houras = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            if (yN == 'y'){
                System.out.print("Additional Charge: ");
                Double additionalCharge = sc.nextDouble();
                employees.add(new OutSourcedEmployee(name, houras, valuePerHour, additionalCharge));
            }
            else {
                employees.add(new Employee(name, houras, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("Payments: ");
        for (Employee j : employees){
            System.out.println(j.getName() + " - $ " + String.format("%.2f", j.payment()) );
        }


    }
}
