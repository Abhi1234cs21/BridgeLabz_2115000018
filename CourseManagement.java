class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName;

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
}

public class CourseManagement {
    public static void main(String[] args) {
        Course.instituteName = "Tech Academy";

        Course course1 = new Course();
        course1.courseName = "Java Programming";
        course1.duration = 6;
        course1.fee = 500.0;
        course1.displayCourseDetails();

        Course course2 = new Course();
        course2.courseName = "Python Programming";
        course2.duration = 4;
        course2.fee = 400.0;
        course2.displayCourseDetails();

        Course.updateInstituteName("Code University");

        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
