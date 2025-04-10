import org.example.AnalyzeManagersSalary;
import org.example.Employee;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeUtilsTest {

    @Test
    public void testFindUnderpaidManagers() {
        Employee ceo = new Employee(1, "Alice", "CEO", 200000, null);
        Employee bob = new Employee(2, "Bob", "Mgr1", 85000, 1);
        Employee dave = new Employee(3, "Dave", "Dev", 100000, 2);
        Employee eve = new Employee(4, "Eve", "Dev", 90000, 2);

        List<Employee> employees = Arrays.asList(ceo, bob, dave, eve);
        List<Employee> underpaid = (new AnalyzeManagersSalary()).analyzeManagersSalary(employees)[0];

        assertEquals(1, underpaid.size());
        assertEquals(bob.id, underpaid.get(0).id);
    }

    @Test
    public void testFindDeepEmployees() {

        Employee ceo = new Employee(1, "Alice", "CEO", 200000, null);
        Employee m1 = new Employee(2, "M1", "Mid", 150000, 1);
        Employee m2 = new Employee(3, "M2", "Mid", 140000, 2);
        Employee m3 = new Employee(4, "M3", "Mid", 130000, 3);
        Employee m4 = new Employee(5, "M4", "Mid", 120000, 4);
        Employee m5 = new Employee(6, "M5", "Mid", 110000, 5);
        Employee emp = new Employee(7, "John", "Dev", 100000, 6);

        List<Employee> employees = Arrays.asList(ceo, m1, m2, m3, m4, m5, emp);
        List<Employee> deep = (new AnalyzeManagersSalary()).findDeepEmployees(employees);

        assertEquals(2, deep.size());

    }

    @Test
    public void testNoUnderpaidManagers() {
        Employee ceo = new Employee(1, "Alice", "CEO", 300000, null);
        Employee mgr = new Employee(2, "Bob", "Manager", 120000, 1);
        Employee dev1 = new Employee(3, "Dev1", "Engineer", 100000, 2);
        Employee dev2 = new Employee(4, "Dev2", "Engineer", 90000, 2);

        List<Employee> employees = Arrays.asList(ceo, mgr, dev1, dev2);
        List<Employee> underpaid = (new AnalyzeManagersSalary()).analyzeManagersSalary(employees)[0];

        assertTrue(underpaid.isEmpty());
    }

    @Test
    public void testFindOverpaidManagers() {
        Employee ceo = new Employee(1, "Alice", "CEO", 200000, null);
        Employee bob = new Employee(2, "Bob", "Mgr1", 200000, 1);
        Employee dave = new Employee(3, "Dave", "Dev", 100000, 2);
        Employee eve = new Employee(4, "Eve", "Dev", 90000, 2);

        List<Employee> employees = Arrays.asList(ceo, bob, dave, eve);
        List<Employee> underpaid = (new AnalyzeManagersSalary()).analyzeManagersSalary(employees)[1];

        assertEquals(1, underpaid.size());
        assertEquals(bob.id, underpaid.get(0).id);
    }
    @Test
    public void testNoOverpaidManagers() {
        Employee ceo = new Employee(1, "Alice", "CEO", 300000, null);
        Employee mgr = new Employee(2, "Bob", "Manager", 100000, 1);
        Employee dev1 = new Employee(3, "Dev1", "Engineer", 100000, 2);
        Employee dev2 = new Employee(4, "Dev2", "Engineer", 90000, 2);

        List<Employee> employees = Arrays.asList(ceo, mgr, dev1, dev2);
        List<Employee> overpaid = (new AnalyzeManagersSalary()).analyzeManagersSalary(employees)[1];

        assertTrue(overpaid.isEmpty());
    }

}