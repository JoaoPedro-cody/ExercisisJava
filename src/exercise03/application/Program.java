package exercise03.application;

import exercise03.entities.Client;
import exercise03.entities.Order;
import exercise03.entities.OrderItem;
import exercise03.entities.Product;
import exercise03.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = fmt1.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter  #" + (i + 1) + " item data:");

            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double price = sc.nextDouble();

            Product product = new Product(productName, price);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem item = new OrderItem(quantity, price, product);
            order.addItem(item);
        }

        System.out.println();
        System.out.println("Order Summary: ");
        System.out.println(order);
        System.out.println("Order item");

        sc.close();
    }
}
