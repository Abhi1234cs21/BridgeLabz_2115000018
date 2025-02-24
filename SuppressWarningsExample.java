import java.util.ArrayList;

public class SuppressWarningsExample {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Creating an ArrayList without generics
        ArrayList list = new ArrayList(); 
        
        // Adding elements (without type safety)
        list.add("Hello");
        list.add(100); // Mixing data types
        
        // Retrieving elements
        System.out.println(list.get(0)); // Output: Hello
        System.out.println(list.get(1)); // Output: 100
    }
}
