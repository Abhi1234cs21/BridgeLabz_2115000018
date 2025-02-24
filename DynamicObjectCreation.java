import java.lang.reflect.*;

class Student {
    private String name;
    
    public Student() {
        this.name = "Default Student";
    }
    
    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Student");
            Object studentObj = clazz.getDeclaredConstructor().newInstance();
            
            Method displayMethod = clazz.getMethod("display");
            displayMethod.invoke(studentObj);
            
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}