import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Define the @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveComputation {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for " + n);
            return cache.get(n);
        }
        System.out.println("Computing factorial of " + n);
        int result = n * factorial(n - 1);
        cache.put(n, result);
        return result;
    }
}

public class CustomCachingSystem {
    public static void main(String[] args) {
        ExpensiveComputation computation = new ExpensiveComputation();

        System.out.println("Factorial of 5: " + computation.factorial(5));
        System.out.println("Factorial of 4: " + computation.factorial(4)); // Cached result
        System.out.println("Factorial of 5: " + computation.factorial(5)); // Cached result
    }
}
