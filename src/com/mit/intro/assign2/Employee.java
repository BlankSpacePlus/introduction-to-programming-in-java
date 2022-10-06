package com.mit.intro.assign2;

public class Employee {

    private String name;

    private double basePay;

    private int workHour;

    public Employee() {
    }

    public Employee(String name, double basePay, int workHour) {
        this.name = name;
        this.basePay = basePay;
        this.workHour = workHour;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePay() {
        return this.basePay;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    public int getWorkHour() {
        return this.workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public double getMoneyShouldPay() throws EmployeeException {
        if (this.basePay < 8.00) {
            throw new EmployeeException(this.name + "'s base pay must not be less than $8.00.");
        }
        if (this.workHour > 60) {
            throw new EmployeeException(this.name + "'s work hours must not be greater than 60h.");
        }
        if (this.workHour > 40) {
            return this.basePay * 40 + 1.5 * this.basePay * (this.workHour - 40);
        }
        return this.basePay * this.workHour;
    }

}
