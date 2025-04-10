package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeManagersSalary {

    public List<Employee> findUnderpaidManagers(List<Employee> employees) {
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
            if (manager != null && manager.salary < (1.2 * avgSubordinateSalary)) {
                underpaidManagers.add(manager);
            }
            if (manager != null && manager.salary > (1.5 * avgSubordinateSalary)) {
                overpaidManagers.add(manager);
            }
        }

        return underpaidManagers;
    }
}
