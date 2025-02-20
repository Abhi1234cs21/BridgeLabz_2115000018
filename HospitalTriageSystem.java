import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Create a priority queue with a custom comparator to prioritize higher severity levels
        PriorityQueue<Patient> pq = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                // Higher severity should have higher priority (treated first)
                return Integer.compare(p2.severity, p1.severity);
            }
        });

        // Add patients to the queue
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        // Process and treat patients based on their priority
        System.out.println("Treatment order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
