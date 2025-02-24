import java.lang.annotation.*;
import java.lang.reflect.Field;

// Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();

                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthValidation {
    public static void main(String[] args) {
        try {
            User validUser = new User("JohnDoe");
            System.out.println("Valid user created: " + validUser.getUsername());

            User invalidUser = new User("LongUsername123");
            System.out.println("Invalid user created: " + invalidUser.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
