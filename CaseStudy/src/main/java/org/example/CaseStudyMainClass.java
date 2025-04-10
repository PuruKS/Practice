package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CaseStudyMainClass {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        // 1.Write a simple program which will read the file and report:

        CSVProcessor csvProcessor = new CSVProcessor();
        List<Employee> employees = csvProcessor.getEmployeesFromCSV();
        System.out.println("Size " +employees.size());

        //2.which managers earn less than they should, and by how much

        AnalyzeManagersSalary analyzeManagersSalary = new AnalyzeManagersSalary();
        List<Employee> underPaidManagers = analyzeManagersSalary.findUnderpaidManagers(employees);
        System.out.println(underPaidManagers.size());
    }


}