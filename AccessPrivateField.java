import java.lang.reflect.*;

class Person {
    private int age;
    
    public Person(int age) {
        this.age = age;
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            Class<?> clazz = person.getClass();
            
            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            
            System.out.println("Original Age: " + ageField.get(person));
            ageField.set(person, 30);
            System.out.println("Modified Age: " + ageField.get(person));
            
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
