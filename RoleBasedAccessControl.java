import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully.");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed successfully.");
    }

    public void executeIfAllowed(User user, String methodName) {
        try {
            Method method = this.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (user.getRole().equals(roleAllowed.value())) {
                    method.invoke(this);
                } else {
                    System.out.println("Access Denied! Only " + roleAllowed.value() + " can access this method.");
                }
            } else {
                method.invoke(this);
            }
        } catch (Exception e) {
            System.out.println("Error executing method: " + e.getMessage());
        }
    }
}

public class RoleBasedAccessControl {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        SecureService service = new SecureService();

        System.out.println("Admin trying to access adminTask:");
        service.executeIfAllowed(adminUser, "adminTask");

        System.out.println("\nUser trying to access adminTask:");
        service.executeIfAllowed(normalUser, "adminTask");

        System.out.println("\nUser trying to access userTask:");
        service.executeIfAllowed(normalUser, "userTask");

        System.out.println("\nAdmin trying to access userTask:");
        service.executeIfAllowed(adminUser, "userTask");
    }
}
