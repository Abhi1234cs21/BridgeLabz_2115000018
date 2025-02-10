abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary > 0) {
            this.baseSalary = baseSalary;
        }
    }

    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
    }
}

class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String employeeId, String name, double baseSalary, double hourlyRate, int hoursWorked) {
        super(employeeId, name, baseSalary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hourlyRate * hoursWorked);
    }
}

interface Department {
    void assignDepartment(String departmentName);
    void getDepartmentDetails();
}

class EmployeeDepartment implements Department {
    private String departmentName;

    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Department: " + departmentName);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        FullTimeEmployee fte = new FullTimeEmployee("FT001", "Alice", 5000, 1000);
        PartTimeEmployee pte = new PartTimeEmployee("PT001", "Bob", 2000, 20, 100);

        EmployeeDepartment dept = new EmployeeDepartment();
        dept.assignDepartment("HR");
        dept.getDepartmentDetails();

        Employee emp1 = fte;
        emp1.displayDetails();
        System.out.println("Salary: " + emp1.calculateSalary());

        Employee emp2 = pte;
        emp2.displayDetails();
        System.out.println("Salary: " + emp2.calculateSalary());
    }
}
