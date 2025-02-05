import java.util.ArrayList;

class Course {
    private String courseName;
    private Professor professor;
    private ArrayList<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + professor.getName());
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void showCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        Course course1 = new Course("Computer Science 101");
        Course course2 = new Course("Mathematics 101");

        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);

        student2.enrollCourse(course1);

        student1.showCourses();
        student2.showCourses();

        course1.showCourseDetails();
        course2.showCourseDetails();
    }
}
