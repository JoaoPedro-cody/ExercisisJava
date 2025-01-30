package exercise14.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String path = sc.next();
        Map<String, Integer> map = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                if (map.containsKey(fields[0])){
                     Integer soma = Integer.parseInt(fields[1]) + map.get(fields[0]);
                     map.put(fields[0], soma);
                }
                else {
                    map.put(fields[0], Integer.parseInt(fields[1]));
                }
                line = br.readLine();
            }

            for (String key : map.keySet()){
                System.out.println(key + ": " + map.get(key));
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
