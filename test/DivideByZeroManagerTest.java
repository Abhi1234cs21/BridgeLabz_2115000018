import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivideByZeroManagerTest {
    @Test
    void testDivideByZeroException() {
        DivideByZeroManager manager = new DivideByZeroManager();
        
        // Check if ArithmeticException is thrown when dividing by zero
        assertThrows(ArithmeticException.class, () -> {
            manager.divide(10, 0);
        });
    }

    @Test
    void testValidDivision() {
        DivideByZeroManager manager = new DivideByZeroManager();
        assertEquals(5, manager.divide(10, 2)); // Check normal division
    }
}
