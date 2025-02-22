import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    @Test
    void testValidDateFormat() {
        assertEquals("25-12-2024", DateFormatter.formatDate("2024-12-25"), "Date format should be converted correctly");
        assertEquals("01-01-2025", DateFormatter.formatDate("2025-01-01"), "New Year should be formatted correctly");
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("12/25/2024"));
        assertEquals("Invalid date format, expected yyyy-MM-dd", exception.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2024-13-01"));
        assertEquals("Invalid date format, expected yyyy-MM-dd", exception2.getMessage());
    }
}
