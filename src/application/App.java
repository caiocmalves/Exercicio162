package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of employees: ");
        int n = sc.nextInt();

        List<Employee> lista = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + " data:" );            
            System.out.print("Outsourced (y/n) ?");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Hours: ");
            int hours = sc.nextInt();
            System.out.println("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            if (ch == 'y') {
                System.out.println("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                lista.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                lista.add(new Employee(name, hours, valuePerHour));
            }
            
        }

        System.out.println("PAYMENTS:");
        for (Employee emp : lista) {
            System.out.printf("%s - $ %.2f%n", emp.getName(), emp.payment());
            
        }



        sc.close();


    }
}
