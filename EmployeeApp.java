class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void modifySalary(double newSalary) {
        this.salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}

public class EmployeeApp {
    public static void main(String[] args) {
        Manager manager = new Manager(101, "Sales", 75000);
        manager.displayInfo();
        System.out.println("Salary: " + manager.getSalary());

        manager.modifySalary(80000);
        System.out.println("Updated Salary: " + manager.getSalary());
    }
}
