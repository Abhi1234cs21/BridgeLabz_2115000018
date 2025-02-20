import java.util.*;

public class GroupEmployeesByDepartment {

    public static void main(String[] args) {
        // Creating sample Employee objects
        Employee alice = new Employee("Alice", Department.HR);
        Employee bob = new Employee("Bob", Department.IT);
        Employee carol = new Employee("Carol", Department.HR);

        // List of employees
        List<Employee> employees = Arrays.asList(alice, bob, carol);
        
        // Group employees by department
        Map<Department, List<Employee>> groupedByDepartment = groupByDepartment(employees);
        
        // Print grouped employees
        for (Map.Entry<Department, List<Employee>> entry : groupedByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to group employees by their department
    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        // Using a HashMap to store the department as the key and list of employees as the value
        Map<Department, List<Employee>> departmentMap = new HashMap<>();
        
        // Iterate over each employee and group by their department
        for (Employee employee : employees) {
            Department department = employee.getDepartment();
            
            // If the department is not already in the map, add it with an empty list
            departmentMap.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
        }
        
        return departmentMap;
    }
}

// Employee class
class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Department enum
enum Department {
    HR, IT, SALES, MARKETING
}
