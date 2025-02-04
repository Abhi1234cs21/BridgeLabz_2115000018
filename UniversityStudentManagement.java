class Student {
    static String universityName = "ABC University";
    static int totalStudents = 0;
    
    final String rollNumber;
    String name;
    String grade;

    Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    void updateGrade(String newGrade) {
        this.grade = newGrade;
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", "S12345", "A");
        Student s2 = new Student("Jane Smith", "S67890", "B");

        if (s1 instanceof Student) {
            s1.displayDetails();
        }

        if (s2 instanceof Student) {
            s2.displayDetails();
        }

        System.out.println("\nUpdating grade for student 1...");
        s1.updateGrade("A+");

        if (s1 instanceof Student) {
            s1.displayDetails();
        }

        Student.displayTotalStudents();
    }
}
