import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {

    @Todo(task = "Implement login validation", assignedTo = "Alice", priority = "HIGH")
    public void validateLogin() {
        System.out.println("Validating login...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Optimizing database...");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Charlie", priority = "LOW")
    public void improveUI() {
        System.out.println("Improving UI responsiveness...");
    }
}

public class TodoAnnotationProcessor {
    public static void main(String[] args) {
        try {
            Method[] methods = Project.class.getDeclaredMethods();

            System.out.println("Pending Tasks:");
            for (Method method : methods) {
                if (method.isAnnotationPresent(Todo.class)) {
                    Todo todo = method.getAnnotation(Todo.class);
                    System.out.println("Task: " + todo.task());
                    System.out.println("Assigned To: " + todo.assignedTo());
                    System.out.println("Priority: " + todo.priority());
                    System.out.println("Method: " + method.getName());
                    System.out.println("----------------------");
                }
            }

            Project project = new Project();
            project.validateLogin();
            project.optimizeDatabase();
            project.improveUI();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
