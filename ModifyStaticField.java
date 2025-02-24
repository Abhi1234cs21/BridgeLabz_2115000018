import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Configuration.class;
            Field apiKeyField = clazz.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            
            System.out.println("Original API_KEY: " + apiKeyField.get(null));
            apiKeyField.set(null, "NEW_SECRET_KEY");
            System.out.println("Modified API_KEY: " + apiKeyField.get(null));
            
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}