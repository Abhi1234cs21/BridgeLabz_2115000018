import java.lang.reflect.*;
import java.util.*;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                try {
                    Field field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true);
                    field.set(instance, entry.getValue());
                } catch (NoSuchFieldException e) {
                    System.out.println("Field not found: " + entry.getKey());
                }
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Error creating object", e);
        }
    }
}

class User {
    private String name;
    private int age;
    
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CustomObjectMapper {
    public static void main(String[] args) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "John Doe");
        properties.put("age", 30);
        
        User user = ObjectMapper.toObject(User.class, properties);
        user.display();
    }
}