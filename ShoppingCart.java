import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {
        // Initialize the shopping cart and product prices (HashMap)
        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("Laptop", 800.00);
        productPrices.put("Headphones", 50.00);
        productPrices.put("Smartphone", 600.00);
        productPrices.put("Watch", 120.00);

        // Initialize LinkedHashMap to maintain the order of items added to the cart
        Map<String, Double> cart = new LinkedHashMap<>();

        // Add items to the cart with their prices
        addItemToCart(cart, productPrices, "Laptop");
        addItemToCart(cart, productPrices, "Smartphone");
        addItemToCart(cart, productPrices, "Watch");

        // Display the items in the cart in the order they were added
        System.out.println("Items in the cart (Insertion Order):");
        displayCart(cart);

        // Display items sorted by price using TreeMap
        System.out.println("\nItems in the cart sorted by price:");
        displaySortedCartByPrice(cart);
    }

    // Method to add an item to the cart
    public static void addItemToCart(Map<String, Double> cart, Map<String, Double> productPrices, String itemName) {
        if (productPrices.containsKey(itemName)) {
            cart.put(itemName, productPrices.get(itemName));
        } else {
            System.out.println("Item " + itemName + " not available.");
        }
    }

    // Method to display cart items (Insertion Order)
    public static void displayCart(Map<String, Double> cart) {
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Method to display cart items sorted by price (using TreeMap)
    public static void displaySortedCartByPrice(Map<String, Double> cart) {
        // Convert the LinkedHashMap to a TreeMap to sort by price (ascending order)
        Map<String, Double> sortedCart = new TreeMap<>(new PriceComparator(cart));
        sortedCart.putAll(cart);

        // Display the sorted items
        for (Map.Entry<String, Double> entry : sortedCart.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Custom Comparator for sorting items by price in ascending order
    static class PriceComparator implements Comparator<String> {
        private final Map<String, Double> prices;

        public PriceComparator(Map<String, Double> prices) {
            this.prices = prices;
        }

        @Override
        public int compare(String item1, String item2) {
            return Double.compare(prices.get(item1), prices.get(item2));
        }
    }
}
