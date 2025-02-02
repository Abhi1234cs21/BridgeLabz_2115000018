public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double costPerDay;

    public CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
    }

    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("John Doe", "Toyota Corolla", 5, 50.0);
        CarRental rental2 = new CarRental("Jane Smith", "Honda Civic", 3, 60.0);

        System.out.println(rental1.customerName + " rented a " + rental1.carModel + " for " + rental1.rentalDays + " days. Total cost: $" + rental1.calculateTotalCost());
        System.out.println(rental2.customerName + " rented a " + rental2.carModel + " for " + rental2.rentalDays + " days. Total cost: $" + rental2.calculateTotalCost());
    }
}
