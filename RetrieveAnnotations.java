import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Author Name")
class Book {
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Book.class;
            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No Author annotation present.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}