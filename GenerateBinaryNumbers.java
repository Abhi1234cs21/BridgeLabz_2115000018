import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int N = 5;
        generateBinaryNumbers(N);
    }

    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();

        // Start with "1"
        queue.add("1");

        // Generate and print binary numbers
        for (int i = 0; i < N; i++) {
            // Remove the front element from the queue
            String current = queue.remove();

            // Print the current binary number
            System.out.println(current);

            // Generate next binary numbers by appending "0" and "1" to the current number
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}
