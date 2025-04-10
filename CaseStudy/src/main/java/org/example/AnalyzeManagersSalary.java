package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeManagersSalary {

    public List<Employee>[] analyzeManagersSalary(List<Employee> employees) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        Map<Integer, List<Employee>> managerToSubordinates = new HashMap<>();

        // Build maps
        for (Employee emp : employees) {
            employeeMap.put(emp.id, emp);
            if (emp.managerId != null) {
                managerToSubordinates
                        .computeIfAbsent(emp.managerId, k -> new ArrayList<>())
                        .add(emp);
            }
        }

        List<Employee>[] arrayOfList = new List[2];
        List<Employee> underpaidManagers = new ArrayList<>();
        List<Employee> overpaidManagers = new ArrayList<>();

        for (Map.Entry<Integer, List<Employee>> entry : managerToSubordinates.entrySet()) {
            int managerId = entry.getKey();
            List<Employee> subordinates = entry.getValue();

            double avgSubordinateSalary = subordinates.stream()
                    .mapToDouble(e -> e.salary)
                    .average()
                    .orElse(0.0);

            Employee manager = employeeMap.get(managerId);
            if (manager != null && manager.salary < (1.2 * avgSubordinateSalary) && null != manager.managerId ) {
                manager.salaryDifference = (1.2 * avgSubordinateSalary) - manager.salary;
                underpaidManagers.add(manager);
            }
            if (manager != null && manager.salary > (1.5 * avgSubordinateSalary) && null != manager.managerId)  {
                manager.salaryDifference =  manager.salary - (1.5 * avgSubordinateSalary) ;
                overpaidManagers.add(manager);
            }
        }
        arrayOfList[0] = underpaidManagers;
        arrayOfList[1] = overpaidManagers;

        return arrayOfList;
    }


    public List<Employee> findDeepEmployees(List<Employee> employees) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee emp : employees) {
            employeeMap.put(emp.id, emp);
        }

        List<Employee> deepEmployees = new ArrayList<>();

        for (Employee emp : employees) {
            int depth = 0;
            Integer managerId = emp.managerId;

            while (managerId != null) {
                depth++;
                Employee manager = employeeMap.get(managerId);
                if (manager == null) break;
                managerId = manager.managerId;
            }

            if (depth > 4) {
                emp.reportingLine = depth;
                deepEmployees.add(emp);
            }
        }

        return deepEmployees;
    }
}
