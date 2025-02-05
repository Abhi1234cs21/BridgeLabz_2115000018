import java.util.ArrayList;

class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Doctor {
    private String name;
    private ArrayList<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " is consulting with " + patient.getName());
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " is consulting with the following patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}

class Hospital {
    private String hospitalName;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalName() {
        return hospitalName;
    }
}

public class HospitalDoctorPatientDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Smith");
        Doctor doctor2 = new Doctor("Johnson");

        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        doctor1.consult(patient1);
        doctor1.consult(patient2);

        doctor2.consult(patient1);

        doctor1.showPatients();
        doctor2.showPatients();
    }
}
