import java.util.List;
import java.util.ArrayList;

abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
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

class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName() + " - " + item.getCategory() + " - $" + item.getPrice());
        }
    }

    public List<T> getItems() {
        return items;
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 1500.00));
        electronicsStorage.addItem(new Electronics("Smartphone", 800.00));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apple", 1.00));
        groceriesStorage.addItem(new Groceries("Milk", 2.50));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Sofa", 500.00));
        furnitureStorage.addItem(new Furniture("Table", 120.00));

        System.out.println("Displaying Electronics:");
        electronicsStorage.displayItems(electronicsStorage.getItems());

        System.out.println("\nDisplaying Groceries:");
        groceriesStorage.displayItems(groceriesStorage.getItems());

        System.out.println("\nDisplaying Furniture:");
        furnitureStorage.displayItems(furnitureStorage.getItems());
    }
}
