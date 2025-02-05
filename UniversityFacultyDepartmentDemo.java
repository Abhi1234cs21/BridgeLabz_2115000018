import java.util.ArrayList;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String departmentName;
    private ArrayList<Faculty> facultyMembers;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.facultyMembers = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void showFaculty() {
        System.out.println("Faculty in " + departmentName + " Department:");
        for (Faculty faculty : facultyMembers) {
            System.out.println(faculty.getName());
        }
    }
}

class University {
    private String universityName;
    private ArrayList<Department> departments;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void showDepartments() {
        System.out.println("Departments in " + universityName + ":");
        for (Department department : departments) {
            System.out.println(department.getDepartmentName());
            department.showFaculty();
        }
    }

    public void deleteUniversity() {
        departments.clear();
        System.out.println(universityName + " and all its departments have been deleted.");
    }
}

public class UniversityFacultyDepartmentDemo {
    public static void main(String[] args) {
        University university = new University("Global University");

        Faculty faculty1 = new Faculty("Dr. John Smith");
        Faculty faculty2 = new Faculty("Dr. Alice Johnson");
        Faculty faculty3 = new Faculty("Dr. Bob White");

        Department department1 = new Department("Computer Science");
        Department department2 = new Department("Electrical Engineering");

        department1.addFaculty(faculty1);
        department1.addFaculty(faculty2);

        department2.addFaculty(faculty3);

        university.addDepartment(department1);
        university.addDepartment(department2);

        university.showDepartments();

        university.deleteUniversity();
    }
}
