import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class ExecutionTracker {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fast method...");
        for (int i = 0; i < 1000; i++); // Simulating a small task
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slow method...");
        for (long i = 0; i < 1_000_000_000L; i++); // Simulating a heavier task
    }
}

public class ExecutionTimeLogger {
    public static void main(String[] args) {
        try {
            ExecutionTracker tracker = new ExecutionTracker();
            Method[] methods = ExecutionTracker.class.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    long startTime = System.nanoTime();
                    method.invoke(tracker);
                    long endTime = System.nanoTime();

                    long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                    System.out.println("Method: " + method.getName() + " | Execution Time: " + executionTime + " ms");
                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
