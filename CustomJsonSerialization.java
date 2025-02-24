import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    private int age; // This field is not annotated and won't be included in JSON

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

class JsonSerializer {
    public static String serialize(Object obj) {
        try {
            Class<?> objClass = obj.getClass();
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : objClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonMap.put(annotation.name(), field.get(obj).toString());
                }
            }

            return jsonMap.toString().replace("=", ": "); // Convert to JSON format
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}

public class CustomJsonSerialization {
    public static void main(String[] args) {
        User user = new User("JohnDoe", "john@example.com", 25);
        String jsonOutput = JsonSerializer.serialize(user);
        System.out.println(jsonOutput);
    }
}
