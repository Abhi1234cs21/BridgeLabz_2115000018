public class PerformanceUtils {
    public static String longRunningTask() {
        try {
            Thread.sleep(1500); // Reduced from 3000ms to 1500ms (1.5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task Completed";
    }
}
