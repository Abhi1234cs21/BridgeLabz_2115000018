import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    
    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}

public class AnnotationProcessor {
    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getMethod("completeTask");

            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            TaskManager taskManager = new TaskManager();
            taskManager.completeTask();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
