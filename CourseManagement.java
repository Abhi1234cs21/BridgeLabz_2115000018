class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseDetails() {
        return "Course: " + courseName + ", Duration: " + duration + " hours";
    }
}

interface Online {
    String getPlatform();
    boolean isRecorded();
}

class OnlineCourse {
    Course course;
    String platform;
    boolean isRecorded;

    OnlineCourse(Course course, String platform, boolean isRecorded) {
        this.course = course;
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    public String getCourseDetails() {
        return course.getCourseDetails() + ", Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No");
    }
}

class PaidOnlineCourse {
    OnlineCourse onlineCourse;
    double fee;
    double discount;

    PaidOnlineCourse(OnlineCourse onlineCourse, double fee, double discount) {
        this.onlineCourse = onlineCourse;
        this.fee = fee;
        this.discount = discount;
    }

    public double getFinalFee() {
        return fee - (fee * discount / 100);
    }

    public String getCourseDetails() {
        return onlineCourse.getCourseDetails() + ", Fee: $" + fee + ", Discount: " + discount + "%, Final Fee: $" + getFinalFee();
    }
}

public class CourseManagement {
    public static void main(String[] args) {
        Course course = new Course("Basic Java Programming", 30);
        OnlineCourse onlineCourse = new OnlineCourse(course, "Udemy", true);
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse(onlineCourse, 200, 10);

        System.out.println(course.getCourseDetails());
        System.out.println(onlineCourse.getCourseDetails());
        System.out.println(paidOnlineCourse.getCourseDetails());
    }
}
