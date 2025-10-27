package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;


public class Main {
    public static String findEmployeeByName(Map<String, Employee> employeeMap, String name) {
        Employee emp = employeeMap.get(name.toLowerCase());
        if (emp != null) {
            return "Employee found: " + emp.toString();
        } else {
            return "Employee not found.";
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Alice", 50000));
        employees.add(new Employee(2, "Bob", 60000));
        employees.add(new Employee(3, "Charlie", 55000));
        employees.add(new Employee(4, "David", 70000));
        employees.add(new Employee(5, "Eve", 65000));
        employees.add(new Employee(6, "Frank", 72000));
        employees.add(new Employee(7, "Grace", 48000));
        employees.add(new Employee(8, "Hannah", 53000));
        employees.add(new Employee(9, "Ian", 59000));
        employees.add(new Employee(10, "Judy", 61000));

        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee emp : employees) {
            employeeMap.put(emp.getName().toLowerCase(), emp);
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String name = scanner.nextLine();
        
        String result = findEmployeeByName(employeeMap, name);
        System.out.println(result);

        scanner.close();
    }
}
