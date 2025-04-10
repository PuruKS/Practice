package org.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public int id;
    String firstName;
    String lastName;
    double salary;
    Integer managerId;

    double salaryDifference;

    int reportingLine = 0;


    public Employee(int id, String firstName, String lastName, double salary, Integer managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", managerId=" + managerId +
                ", salaryDifference=" + salaryDifference +
                ", reporting line count=" +reportingLine +
                '}';
    }
}
