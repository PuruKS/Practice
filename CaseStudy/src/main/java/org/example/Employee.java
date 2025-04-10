package org.example;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    int id;
    String firstName;
    String lastName;
    double salary;
    Integer managerId;


    public Employee(int id, String firstName, String lastName, double salary, Integer managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerId = managerId;
    }

}
