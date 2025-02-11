class TaskNode {
    int taskID;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskID, String taskName, int priority, String dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private TaskNode head;

    public TaskScheduler() {
        this.head = null;
    }

    public void addAtBeginning(int taskID, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            TaskNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newTask;
            newTask.next = head;
            head = newTask;
        }
    }

    public void addAtEnd(int taskID, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            TaskNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(int taskID, String taskName, int priority, String dueDate, int position) {
        TaskNode newTask = new TaskNode(taskID, taskName, priority, dueDate);
        if (position == 0) {
            addAtBeginning(taskID, taskName, priority, dueDate);
        } else {
            TaskNode current = head;
            int currentPos = 0;
            while (current != null && currentPos < position - 1) {
                current = current.next;
                currentPos++;
            }
            if (current == null) {
                System.out.println("Position out of range.");
            } else {
                newTask.next = current.next;
                current.next = newTask;
            }
        }
    }

    public void removeByTaskID(int taskID) {
        if (head == null) {
            return;
        }
        if (head.taskID == taskID) {
            if (head.next == head) {
                head = null;
            } else {
                TaskNode current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next;
                head = head.next;
            }
            return;
        }
        TaskNode current = head;
        while (current.next != head && current.next.taskID != taskID) {
            current = current.next;
        }
        if (current.next != head) {
            current.next = current.next.next;
        }
    }

    public TaskNode searchByPriority(int priority) {
        TaskNode current = head;
        if (current == null) return null;
        do {
            if (current.priority == priority) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + head.taskName + ", Task ID: " + head.taskID + ", Priority: " + head.priority + ", Due Date: " + head.dueDate);
    }

    public void moveToNextTask() {
        if (head == null || head.next == head) {
            System.out.println("No next task available.");
            return;
        }
        head = head.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        do {
            System.out.println("Task ID: " + current.taskID + ", Task Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        
        scheduler.addAtBeginning(1, "Task 1", 3, "2025-02-20");
        scheduler.addAtEnd(2, "Task 2", 1, "2025-02-22");
        scheduler.addAtEnd(3, "Task 3", 2, "2025-02-23");

        scheduler.displayAllTasks();

        scheduler.addAtPosition(4, "Task 4", 5, "2025-02-25", 2);

        scheduler.displayAllTasks();

        scheduler.removeByTaskID(2);

        scheduler.displayAllTasks();

        scheduler.searchByPriority(3);

        scheduler.viewCurrentTask();

        scheduler.moveToNextTask();

        scheduler.viewCurrentTask();
    }
}
