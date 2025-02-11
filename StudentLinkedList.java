class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentLinkedList {
    private StudentNode head;

    public StudentLinkedList() {
        this.head = null;
    }

    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
    }

    public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        if (position == 0) {
            addAtBeginning(rollNumber, name, age, grade);
        } else {
            StudentNode current = head;
            int currentPos = 0;
            while (current != null && currentPos < position - 1) {
                current = current.next;
                currentPos++;
            }
            if (current == null) {
                System.out.println("Position out of range.");
            } else {
                newStudent.next = current.next;
                current.next = newStudent;
            }
        }
    }

    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public StudentNode searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    public void updateGradeByRollNumber(int rollNumber, String newGrade) {
        StudentNode student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        
        list.addAtBeginning(101, "Alice", 20, "A");
        list.addAtEnd(102, "Bob", 21, "B");
        list.addAtEnd(103, "Charlie", 22, "A");

        list.displayAll();

        list.addAtPosition(104, "David", 23, "C", 1);

        list.displayAll();

        list.deleteByRollNumber(102);
        
        list.displayAll();

        list.updateGradeByRollNumber(101, "A+");
        
        list.displayAll();
    }
}
