class ProcessNode {
    int processID;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduling {
    private ProcessNode head;
    private ProcessNode tail;

    public RoundRobinScheduling() {
        this.head = null;
        this.tail = null;
    }

    public void addProcess(int processID, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int processID) {
        if (head == null) return;

        ProcessNode current = head;
        ProcessNode prev = null;

        if (head.processID == processID) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }

        while (current != null && current.processID != processID) {
            prev = current;
            current = current.next;
            if (current == head) break;
        }

        if (current != null && current.processID == processID) {
            prev.next = current.next;
            if (current == tail) {
                tail = prev;
            }
        }
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) return;

        ProcessNode current = head;
        int totalWaitingTime = 0, totalTurnaroundTime = 0;
        int numberOfProcesses = 0;

        ProcessNode temp = head;
        do {
            numberOfProcesses++;
            temp = temp.next;
        } while (temp != head);

        while (numberOfProcesses > 0) {
            if (current.burstTime > timeQuantum) {
                current.burstTime -= timeQuantum;
                totalWaitingTime += timeQuantum;
            } else {
                totalWaitingTime += current.burstTime;
                totalTurnaroundTime += (totalWaitingTime + current.burstTime);
                removeProcess(current.processID);
                numberOfProcesses--;
            }
            current = current.next;
            displayProcesses();
        }

        double avgWaitingTime = (double) totalWaitingTime / numberOfProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / numberOfProcesses;
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        ProcessNode current = head;
        do {
            System.out.println("Process ID: " + current.processID + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        RoundRobinScheduling rrScheduling = new RoundRobinScheduling();

        rrScheduling.addProcess(1, 10, 1);
        rrScheduling.addProcess(2, 5, 2);
        rrScheduling.addProcess(3, 8, 3);
        rrScheduling.addProcess(4, 6, 4);

        int timeQuantum = 4;
        rrScheduling.simulateRoundRobin(timeQuantum);
    }
}
