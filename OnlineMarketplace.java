import java.util.List;
import java.util.ArrayList;

abstract class Product {
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

    public abstract String getCategory();
}

class BookCategory extends Product {
    public BookCategory(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Book";
    }
}

class ClothingCategory extends Product {
    public ClothingCategory(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }
}

class GadgetCategory extends Product {
    public GadgetCategory(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Gadget";
    }
}

class ProductCatalog<T extends Product> {
    private List<T> products;

    public ProductCatalog() {
        products = new ArrayList<>();
    }

    public void addProduct(T product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getCategory() + " - $" + product.getPrice());
        }
    }

    public List<T> getProducts() {
        return products;
    }

    public <T extends Product> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * (percentage / 100));
        System.out.println("Discounted Price for " + product.getName() + ": $" + newPrice);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog<BookCategory> bookCatalog = new ProductCatalog<>();
        bookCatalog.addProduct(new BookCategory("Java Programming", 40.00));
        bookCatalog.addProduct(new BookCategory("Design Patterns", 35.00));

        ProductCatalog<ClothingCategory> clothingCatalog = new ProductCatalog<>();
        clothingCatalog.addProduct(new ClothingCategory("T-Shirt", 20.00));
        clothingCatalog.addProduct(new ClothingCategory("Jeans", 50.00));

        ProductCatalog<GadgetCategory> gadgetCatalog = new ProductCatalog<>();
        gadgetCatalog.addProduct(new GadgetCategory("Smartphone", 700.00));
        gadgetCatalog.addProduct(new GadgetCategory("Laptop", 1200.00));

        System.out.println("Books in Catalog:");
        bookCatalog.displayProducts();
        bookCatalog.applyDiscount(bookCatalog.getProducts().get(0), 10);

        System.out.println("\nClothing in Catalog:");
        clothingCatalog.displayProducts();
        clothingCatalog.applyDiscount(clothingCatalog.getProducts().get(1), 15);

        System.out.println("\nGadgets in Catalog:");
        gadgetCatalog.displayProducts();
        gadgetCatalog.applyDiscount(gadgetCatalog.getProducts().get(0), 5);
    }
}
