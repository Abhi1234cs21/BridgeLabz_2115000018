class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;
    
    final String patientID;
    String name;
    int age;
    String ailment;

    Patient(String name, int age, String ailment) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = "P" + (totalPatients + 1);
        totalPatients++;
    }

    static int getTotalPatients() {
        return totalPatients;
    }

    void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("John Doe", 35, "Flu");
        Patient p2 = new Patient("Jane Smith", 28, "Cold");

        if (p1 instanceof Patient) {
            p1.displayDetails();
        }

        if (p2 instanceof Patient) {
            p2.displayDetails();
        }

        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}
