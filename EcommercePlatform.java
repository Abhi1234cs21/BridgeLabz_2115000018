abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }
    }

    public abstract double calculateDiscount();
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Electronics extends Product {
    private double discountRate;

    public Electronics(String productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate / 100;
    }
}

class Clothing extends Product {
    private double discountAmount;

    public Clothing(String productId, String name, double price, double discountAmount) {
        super(productId, name, price);
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculateDiscount() {
        return discountAmount;
    }
}

interface Taxable {
    double calculateTax();
    void getTaxDetails();
}

class ElectronicsTaxable implements Taxable {
    private Product product;

    public ElectronicsTaxable(Product product) {
        this.product = product;
    }

    @Override
    public double calculateTax() {
        return product.getPrice() * 0.15;
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax Rate: 15%");
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Electronics eProduct = new Electronics("E001", "Laptop", 1000, 10);
        Clothing cProduct = new Clothing("C001", "Shirt", 50, 5);

        Product[] products = {eProduct, cProduct};
        for (Product product : products) {
            product.displayDetails();
            System.out.println("Discount: " + product.calculateDiscount());
            if (product instanceof Electronics) {
                ElectronicsTaxable taxable = new ElectronicsTaxable(product);
                System.out.println("Tax: " + taxable.calculateTax());
                taxable.getTaxDetails();
            }
        }
    }
}
