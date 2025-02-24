import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class MyClass {

    @ImportantMethod(level = "HIGH")
    public void criticalFunction() {
        System.out.println("Executing critical function...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void importantFunction() {
        System.out.println("Executing important function...");
    }

    public void normalFunction() {
        System.out.println("Executing normal function...");
    }
}

public class AnnotationExample {
    public static void main(String[] args) {
        try {
            Method[] methods = MyClass.class.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Important Method: " + method.getName() + " | Level: " + annotation.level());
                }
            }

            MyClass obj = new MyClass();
            obj.criticalFunction();
            obj.importantFunction();
            obj.normalFunction();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
