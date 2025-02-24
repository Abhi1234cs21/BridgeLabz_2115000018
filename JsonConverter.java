import java.lang.reflect.*;
import java.util.*;

class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                json.append("\"" + fields[i].getName() + "\": \"")
                    .append(fields[i].get(obj))
                    .append("\"");
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field", e);
            }
        }
        json.append("}");
        return json.toString();
    }
}

class Person {
    private String name = "Alice";
    private int age = 25;
}

public class JsonConverter {
    public static void main(String[] args) {
        Person person = new Person();
        String json = JsonSerializer.toJson(person);
        System.out.println(json);
    }
}
