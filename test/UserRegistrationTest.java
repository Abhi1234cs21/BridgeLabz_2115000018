import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    @Test
    void testValidRegistration() {
        assertEquals("User registered successfully", UserRegistration.registerUser("JohnDoe", "john.doe@example.com", "Password1"));
    }

    @Test
    void testInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            UserRegistration.registerUser("", "john.doe@example.com", "Password1"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmailFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            UserRegistration.registerUser("JohnDoe", "john.doe.com", "Password1"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testInvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            UserRegistration.registerUser("JohnDoe", "john.doe@example.com", "pass"));
        assertEquals("Password must be at least 8 characters long, contain one uppercase letter, and one digit", exception.getMessage());
    }
}
