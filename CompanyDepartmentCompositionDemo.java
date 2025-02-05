import java.util.ArrayList;

class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void showDepartments() {
        System.out.println("Departments in " + companyName + ":");
        for (Department department : departments) {
            department.showEmployees();
        }
    }

    public void deleteCompany() {
        departments.clear();
        System.out.println(companyName + " and all its departments and employees have been deleted.");
    }
}

class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void showEmployees() {
        System.out.println("  Department: " + departmentName);
        for (Employee employee : employees) {
            System.out.println("    Employee: " + employee.getEmployeeName());
        }
    }

    public void deleteDepartment() {
        employees.clear();
        System.out.println("  Department " + departmentName + " and all its employees have been deleted.");
    }
}

class Employee {
    private String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}

public class CompanyDepartmentCompositionDemo {
    public static void main(String[] args) {
        Company company = new Company("Tech Innovators Inc.");

        company.addDepartment("Software Development");
        company.addDepartment("Human Resources");

        company.showDepartments();

        // Adding employees to departments
        company.departments.get(0).addEmployee("Alice Johnson");
        company.departments.get(0).addEmployee("Bob Smith");

        company.departments.get(1).addEmployee("Charlie Brown");

        System.out.println("\nAfter adding employees:");
        company.showDepartments();

        company.deleteCompany();
    }
}
