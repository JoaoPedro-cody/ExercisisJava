package exercise05.application;

import exercise05.entities.ImportedProduct;
import exercise05.entities.Product;
import exercise05.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.print("Common, used or imported (c/u/i)? ");
            sc.nextLine();
            char yn = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (yn == 'c'){
                list.add(new Product(name, price));
            }
            else
                if (yn == 'u') {
                    System.out.print("Manufacture date DD/MM/YYYY): ");
                    Date manufactyreDAte = sdf.parse(sc.next());
                    list.add(new UsedProduct(name, price, manufactyreDAte));
                }
            else {
                System.out.print("Customs fee: ");
                Double customFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customFee));
            }
        }

        System.out.println();
        System.out.println("Price Tags: ");
        for (Product j : list){
            System.out.println(j.priceTag());
        }
    }
}
