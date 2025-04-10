package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CaseStudyMainClass {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello !");

        // 1.Write a simple program which will read the file and report:
        CSVProcessor csvProcessor = new CSVProcessor();
        List<Employee> employees = csvProcessor.getEmployeesFromCSV();
        System.out.println("Total number of employees :  " +employees.size());
        System.out.println();

        //Analyze Managers Salary
        AnalyzeManagersSalary analyzeManagersSalary = new AnalyzeManagersSalary();
        List<Employee>[] analyzedManagers = analyzeManagersSalary.analyzeManagersSalary(employees);

        //2.which managers earn less than they should, and by how much
        for (Employee employee : analyzedManagers[0])
            System.out.println("Employee "+employee.firstName+"  underpaid by "+ employee.salaryDifference);

        //3.which managers earn more than they should, and by how much
        for (Employee employee : analyzedManagers[1])
            System.out.println("Employee "+employee.firstName+"  overpaid by "+ employee.salaryDifference);

        //4.which employees have a reporting line which is too long, and by how much
           for(Employee employee : analyzeManagersSalary.findDeepEmployees(employees))
               System.out.println("Employee "+employee.firstName+"  has "+employee.reportingLine+" managers btw himself and CEO");
    }


}