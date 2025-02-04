class Product {
    static double discount = 10.0;
    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    double getTotalPrice() {
        return price * quantity * (1 - discount / 100);
    }

    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Product ID: " + productID);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Total Price (after discount): $" + getTotalPrice());
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1000.0, 2, "P12345");
        Product p2 = new Product("Smartphone", 500.0, 1, "P67890");

        if (p1 instanceof Product) {
            p1.displayProductDetails();
        }

        if (p2 instanceof Product) {
            p2.displayProductDetails();
        }

        System.out.println("\nUpdating discount...");
        Product.updateDiscount(15.0);

        System.out.println("\nUpdated Product Details:");
        if (p1 instanceof Product) {
            p1.displayProductDetails();
        }

        if (p2 instanceof Product) {
            p2.displayProductDetails();
        }
    }
}
