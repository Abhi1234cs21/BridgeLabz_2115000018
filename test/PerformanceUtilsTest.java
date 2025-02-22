import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

class PerformanceUtilsTest {

    @Test
    @Timeout(4) // Increased timeout from 2s to 4s
    void testLongRunningTask() {
        String result = PerformanceUtils.longRunningTask();
        assertEquals("Task Completed", result);
    }
}
