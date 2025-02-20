import java.util.*;

public class VotingSystem {

    public static void main(String[] args) {
        // Initialize the HashMap to store votes (Candidate -> Votes)
        Map<String, Integer> votesMap = new HashMap<>();
        
        // Simulate casting votes
        castVote(votesMap, "Alice");
        castVote(votesMap, "Bob");
        castVote(votesMap, "Alice");
        castVote(votesMap, "Charlie");
        castVote(votesMap, "Bob");
        castVote(votesMap, "Alice");

        // Display the votes as they were cast using LinkedHashMap to maintain order
        System.out.println("Votes as they were cast (in insertion order):");
        displayVotesInOrder(votesMap);

        // Display the results in sorted order using TreeMap (sorted by vote count)
        System.out.println("\nSorted by votes (ascending order of votes):");
        displayVotesSortedByVotes(votesMap);
    }

    // Method to cast a vote for a candidate
    public static void castVote(Map<String, Integer> votesMap, String candidate) {
        // Using LinkedHashMap to maintain the order of votes cast
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
    }

    // Method to display votes as they were cast (Insertion order)
    public static void displayVotesInOrder(Map<String, Integer> votesMap) {
        // Use LinkedHashMap to maintain the order of insertion
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(votesMap);
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to display the results sorted by the number of votes using TreeMap
    public static void displayVotesSortedByVotes(Map<String, Integer> votesMap) {
        // Convert the votesMap to a TreeMap to sort it by the number of votes (ascending order)
        Map<String, Integer> sortedByVotesMap = new TreeMap<>(new VoteComparator(votesMap));
        sortedByVotesMap.putAll(votesMap);

        // Display sorted results
        for (Map.Entry<String, Integer> entry : sortedByVotesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

// Custom comparator for sorting the candidates by their vote count (ascending order)
class VoteComparator implements Comparator<String> {
    private final Map<String, Integer> votesMap;

    public VoteComparator(Map<String, Integer> votesMap) {
        this.votesMap = votesMap;
    }

    @Override
    public int compare(String candidate1, String candidate2) {
        return votesMap.get(candidate1).compareTo(votesMap.get(candidate2));
    }
}
