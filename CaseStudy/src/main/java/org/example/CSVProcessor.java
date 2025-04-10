package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVProcessor {
    public List<Employee> getEmployeesFromCSV() throws IOException {

        InputStream input = CSVProcessor.class.getClassLoader().getResourceAsStream("employees.csv");
        List<String> lines = new BufferedReader(new InputStreamReader(input))
                .lines()
                .collect(Collectors.toList());

       List<Employee> employees = new ArrayList<>();

        for (String line : lines.subList(1, lines.size())) {
            String[] tokens = line.split(",");
            int id = Integer.parseInt(tokens[0]);
            String firstName = tokens[1];
            String lastName = tokens[2];
            double salary = Double.parseDouble(tokens[3]);
            Integer managerId = tokens.length > 4 && !tokens[4].isBlank() ? Integer.parseInt(tokens[4]) : null;

            employees.add(new Employee(id, firstName, lastName, salary, managerId));
        }
        return employees;
    }
}
