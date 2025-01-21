package exercise06.app;

import exercise06.ent.Circle;
import exercise06.ent.Rectangle;
import exercise06.ent.Shape;
import exercise06.ent.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Shape #" + (i +1) + " data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char letra = sc.nextLine().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());
            if (letra == 'c'){
                System.out.print("Radius: ");
                Double radius = sc.nextDouble();

                shapes.add(new Circle(color, radius));
            }
            else {
                System.out.print("Width: ");
                Double width = sc.nextDouble();
                System.out.print("Height: ");
                Double height = sc.nextDouble();

                shapes.add(new Rectangle(color, width, height));
            }

            sc.nextLine();
        }

        System.out.println();
        System.out.println("SHAPE AREAS: ");

        for (Shape j : shapes){
            System.out.printf("%.2f%n", j.area());
        }

    }
}
