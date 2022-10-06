package com.mit.intro.assign2;

public class FooCorporation {

    public static void main(String[] args) {
        try {
            Employee employee1 = new Employee("Employee1", 7.50, 35);
            System.out.printf("Employee1 should get $%.2f.\n", employee1.getMoneyShouldPay());
        } catch (EmployeeException e) {
            System.err.println(e.getMessage());
        }
        try {
            Employee employee2 = new Employee("Employee2", 8.20, 47);
            System.out.printf("Employee2 should get $%.2f.\n", employee2.getMoneyShouldPay());
        } catch (EmployeeException e) {
            System.err.println(e.getMessage());
        }
        try {
            Employee employee3 = new Employee("Employee3", 10.00, 73);
            System.out.printf("Employee3 should get $%.2f.\n", employee3.getMoneyShouldPay());
        } catch (EmployeeException e) {
            System.err.println(e.getMessage());
        }
    }

}
