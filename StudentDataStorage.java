import java.io.*;

public class StudentDataStorage {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        storeStudentData();
        retrieveStudentData();
    }

    public static void storeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
            
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);
            
            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error storing student data: " + e.getMessage());
        }
    }

    public static void retrieveStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error retrieving student data: " + e.getMessage());
        }
    }
}
