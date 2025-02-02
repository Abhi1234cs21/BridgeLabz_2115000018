class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0 && CGPA <= 10) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value. CGPA must be between 0 and 10.");
        }
    }

    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {

    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void displayPostgraduateInfo() {
        System.out.println("Postgraduate Student Info:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student student1 = new Student(101, "John Doe", 8.5);
        student1.displayStudentInfo();

        student1.setCGPA(9.2);
        System.out.println("Updated CGPA: " + student1.getCGPA());

        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Alice Smith", 9.0);
        pgStudent.displayPostgraduateInfo();
    }
}
