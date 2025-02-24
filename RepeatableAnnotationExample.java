import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    
    @BugReport(description = "Null pointer exception occurs in edge cases.")
    @BugReport(description = "Performance issue when handling large data sets.")
    public void processBugs() {
        System.out.println("Processing reported bugs...");
    }
}

public class RepeatableAnnotationExample {
    public static void main(String[] args) {
        try {
            Method method = BugTracker.class.getMethod("processBugs");

            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                for (BugReport report : bugReports.value()) {
                    System.out.println("Bug Description: " + report.description());
                }
            }

            BugTracker bugTracker = new BugTracker();
            bugTracker.processBugs();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
