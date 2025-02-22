import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    private static final String TEST_FILE = "testfile.txt";

    @BeforeEach
    void setup() throws IOException {
        // Cleanup before each test
        File file = new File(TEST_FILE);
        if (file.exists()) file.delete();
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, JUnit!";
        FileProcessor.writeToFile(TEST_FILE, content);

        String readContent = FileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "File content should match");
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        FileProcessor.writeToFile(TEST_FILE, "Sample Content");

        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "File should exist after writing");
    }

    @Test
    void testIOExceptionOnNonExistentFile() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"));
    }

    @AfterEach
    void cleanup() {
        File file = new File(TEST_FILE);
        if (file.exists()) file.delete();
    }
}
