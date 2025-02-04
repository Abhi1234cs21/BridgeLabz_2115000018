class Vehicle {
    static double registrationFee = 500.0;
    final String registrationNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    void displayRegistrationDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice Johnson", "Car", "V12345");
        Vehicle v2 = new Vehicle("Bob Smith", "Truck", "V67890");

        if (v1 instanceof Vehicle) {
            v1.displayRegistrationDetails();
        }

        if (v2 instanceof Vehicle) {
            v2.displayRegistrationDetails();
        }

        System.out.println("\nUpdating registration fee...");
        Vehicle.updateRegistrationFee(600.0);

        System.out.println("\nUpdated Registration Details:");
        if (v1 instanceof Vehicle) {
            v1.displayRegistrationDetails();
        }

        if (v2 instanceof Vehicle) {
            v2.displayRegistrationDetails();
        }
    }
}
