import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123"), "Valid password should return true");
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Ab1"), "Password too short should return false");
    }

    @Test
    void testNoUpperCase() {
        assertFalse(PasswordValidator.isValid("secure123"), "Password without uppercase should return false");
    }

    @Test
    void testNoDigit() {
        assertFalse(PasswordValidator.isValid("SecurePass"), "Password without a digit should return false");
    }

    @Test
    void testEmptyPassword() {
        assertFalse(PasswordValidator.isValid(""), "Empty password should return false");
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null), "Null password should return false");
    }
}
