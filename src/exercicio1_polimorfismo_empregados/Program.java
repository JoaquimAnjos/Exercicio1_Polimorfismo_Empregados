/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1_polimorfismo_empregados;

import entities.Employee;
import entities.OutsourcedEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        List<Employee> list = new ArrayList<>();
        
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        
        for (int i=1; i <= n; i++) {
           System.out.println("Employee #" + i + " data:"); 
           System.out.print("Outsourced (y/n)? "); 
           char ch = sc.next().charAt(0);
           System.out.print("Name: ");
           sc.nextLine();
           String name = sc.nextLine();
           System.out.print("Hours: ");
           int hours = sc.nextInt();
           System.out.print("Value per hour: ");
           double valuePerHour = sc.nextDouble();
           if (ch == 'y') {
               System.out.println("Additional charge: ");
               double additionalCharge = sc.nextDouble();
               list.add(new OutsourcedEmployee(additionalCharge, name, hours, valuePerHour));
           } else {
               Employee emp = new Employee(name, hours, valuePerHour);
               list.add(emp);
           }
        }  
        
        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee emp : list) {
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment())); 
        }
        
        sc.close();
    }
    
}
