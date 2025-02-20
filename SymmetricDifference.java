import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> symmetricDifference = symmetricDifference(set1, set2);

        System.out.println("Symmetric Difference: " + symmetricDifference); // Output: {1, 2, 4, 5}
    }

    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> symmetricDiffSet = new HashSet<>(set1);
        symmetricDiffSet.addAll(set2);  // Add all elements from both sets

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);  // Find common elements (intersection)

        symmetricDiffSet.removeAll(intersectionSet);  // Remove common elements from the union

        return symmetricDiffSet;
    }
}
