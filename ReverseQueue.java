import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        
        // Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        // Reversing the queue
        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element, reverse the remaining queue, and add the removed element to the back
        int front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }
}
