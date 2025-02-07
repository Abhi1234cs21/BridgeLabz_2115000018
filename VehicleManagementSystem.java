interface Refuelable {
    void refuel();
}

class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getVehicleDetails() {
        return "Model: " + model + ", Max Speed: " + maxSpeed + " km/h";
    }
}

class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("The electric vehicle is charging. Battery capacity: " + batteryCapacity + " kWh.");
    }

    public String getDetails() {
        return getVehicleDetails() + ", Battery Capacity: " + batteryCapacity + " kWh";
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacity;

    PetrolVehicle(String model, int maxSpeed, int fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("The petrol vehicle is refueling. Fuel tank capacity: " + fuelTankCapacity + " liters.");
    }

    public String getDetails() {
        return getVehicleDetails() + ", Fuel Tank Capacity: " + fuelTankCapacity + " liters";
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle electricVehicle = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle petrolVehicle = new PetrolVehicle("Ford Mustang", 220, 60);

        System.out.println(electricVehicle.getDetails());
        electricVehicle.charge();

        System.out.println(petrolVehicle.getDetails());
        petrolVehicle.refuel();
    }
}
