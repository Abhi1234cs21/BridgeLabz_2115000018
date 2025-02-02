class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee;

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // Class method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicleRegistration {
    public static void main(String[] args) {
        Vehicle.registrationFee = 200.0;

        Vehicle vehicle1 = new Vehicle();
        vehicle1.ownerName = "John Doe";
        vehicle1.vehicleType = "Car";
        vehicle1.displayVehicleDetails();

        Vehicle vehicle2 = new Vehicle();
        vehicle2.ownerName = "Jane Smith";
        vehicle2.vehicleType = "Motorcycle";
        vehicle2.displayVehicleDetails();

        // Updating the registration fee
        Vehicle.updateRegistrationFee(250.0);

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
