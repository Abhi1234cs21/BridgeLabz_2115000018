import java.util.List;
import java.util.ArrayList;

abstract class CourseType {
    private String courseName;
    private int courseCredits;

    public CourseType(String courseName, int courseCredits) {
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public abstract String getEvaluationType();
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName, int courseCredits) {
        super(courseName, courseCredits);
    }

    @Override
    public String getEvaluationType() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, int courseCredits) {
        super(courseName, courseCredits);
    }

    @Override
    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, int courseCredits) {
        super(courseName, courseCredits);
    }

    @Override
    public String getEvaluationType() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private T course;

    public Course(T course) {
        this.course = course;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Credits: " + course.getCourseCredits());
        System.out.println("Evaluation Type: " + course.getEvaluationType());
    }

    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName() + " - " + course.getEvaluationType());
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        List<ExamCourse> examCourses = new ArrayList<>();
        examCourses.add(new ExamCourse("Math 101", 3));
        examCourses.add(new ExamCourse("Physics 101", 4));

        List<AssignmentCourse> assignmentCourses = new ArrayList<>();
        assignmentCourses.add(new AssignmentCourse("Computer Science 101", 3));
        assignmentCourses.add(new AssignmentCourse("History 101", 2));

        List<ResearchCourse> researchCourses = new ArrayList<>();
        researchCourses.add(new ResearchCourse("Artificial Intelligence", 4));
        researchCourses.add(new ResearchCourse("Quantum Computing", 3));

        Course<ExamCourse> examCourse = new Course<>(new ExamCourse("Math 101", 3));
        examCourse.displayCourseDetails();

        Course<AssignmentCourse> assignmentCourse = new Course<>(new AssignmentCourse("Computer Science 101", 3));
        assignmentCourse.displayCourseDetails();

        Course<ResearchCourse> researchCourse = new Course<>(new ResearchCourse("Artificial Intelligence", 4));
        researchCourse.displayCourseDetails();

        System.out.println("\nAll Courses:");
        Course.displayAllCourses(examCourses);
        Course.displayAllCourses(assignmentCourses);
        Course.displayAllCourses(researchCourses);
    }
}
