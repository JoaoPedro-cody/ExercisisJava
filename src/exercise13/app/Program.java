package exercise13.app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students for course A? ");
        int n = sc.nextInt();
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Integer ru = sc.nextInt();
            a.add(ru);
        }

        System.out.print("How many students for course B? ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Integer ru = sc.nextInt();
            b.add(ru);
        }

        System.out.print("How many students for course C? ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Integer ru = sc.nextInt();
            c.add(ru);
        }

        Set<Integer> set = new HashSet<>(a);
        set.addAll(b);
        set.addAll(c);

        System.out.println("Total Students: " + set.size());

    }
}
