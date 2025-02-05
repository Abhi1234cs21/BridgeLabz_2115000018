import java.util.ArrayList;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private ArrayList<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (Product product : products) {
            System.out.println("Product: " + product.getName() + " | Price: $" + product.getPrice());
            total += product.getPrice();
        }
        System.out.println("Total: $" + total);
    }
}

class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void showCustomerOrders() {
        System.out.println("Orders for " + name + ":");
        for (Order order : orders) {
            order.showOrderDetails();
        }
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);
        
        Customer customer1 = new Customer("John Doe");
        
        Order order1 = new Order(1001);
        order1.addProduct(product1);
        order1.addProduct(product2);
        
        Order order2 = new Order(1002);
        order2.addProduct(product3);
        
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);
        
        customer1.showCustomerOrders();
    }
}
