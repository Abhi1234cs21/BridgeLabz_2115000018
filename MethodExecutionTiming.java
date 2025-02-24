import java.lang.reflect.*;

class SampleClass {
    public void fastMethod() {
        System.out.println("Fast method executed");
    }
    
    public void slowMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Slow method executed");
    }
}

class MethodTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            System.out.println("Execution time for " + methodName + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) {
        SampleClass sample = new SampleClass();
        MethodTimer.measureExecutionTime(sample, "fastMethod");
        MethodTimer.measureExecutionTime(sample, "slowMethod");
    }
}
