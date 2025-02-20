import java.util.LinkedList;

public class FindNthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        String result = findNthFromEnd(list, N);
        System.out.println(result);  // Output: D
    }

    public static String findNthFromEnd(LinkedList<String> list, int N) {
        if (list == null || N <= 0 || N > list.size()) {
            return null;
        }

        // Use two pointers: fast and slow
        var fastPointer = list.listIterator();
        var slowPointer = list.listIterator();

        // Move the fast pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (!fastPointer.hasNext()) {
                return null;  // If N is larger than the list size
            }
            fastPointer.next();
        }

        // Move both pointers until the fast pointer reaches the end
        while (fastPointer.hasNext()) {
            fastPointer.next();
            slowPointer.next();
        }

        // slowPointer is now at the Nth element from the end
        return slowPointer.next();
    }
}
