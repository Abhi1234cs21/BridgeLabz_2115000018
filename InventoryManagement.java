class ItemNode {
    String itemName;
    int itemID;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagement {
    private ItemNode head;

    public InventoryManagement() {
        this.head = null;
    }

    public void addAtBeginning(String itemName, int itemID, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String itemName, int itemID, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemID, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            ItemNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    public void addAtPosition(String itemName, int itemID, int quantity, double price, int position) {
        ItemNode newItem = new ItemNode(itemName, itemID, quantity, price);
        if (position == 0) {
            addAtBeginning(itemName, itemID, quantity, price);
        } else {
            ItemNode current = head;
            int currentPos = 0;
            while (current != null && currentPos < position - 1) {
                current = current.next;
                currentPos++;
            }
            if (current != null) {
                newItem.next = current.next;
                current.next = newItem;
            }
        }
    }

    public void removeByItemID(int itemID) {
        if (head == null) {
            return;
        }
        if (head.itemID == itemID) {
            head = head.next;
            return;
        }
        ItemNode current = head;
        while (current.next != null && current.next.itemID != itemID) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void updateQuantityByItemID(int itemID, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemID == itemID) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
    }

    public ItemNode searchByItemID(int itemID) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemID == itemID) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public ItemNode searchByItemName(String itemName) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        ItemNode current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }

    public void sortByItemName() {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSortByName(head);
    }

    public void sortByPrice() {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSortByPrice(head);
    }

    private ItemNode mergeSortByName(ItemNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;
        ItemNode left = mergeSortByName(head);
        ItemNode right = mergeSortByName(nextOfMiddle);
        return mergeByName(left, right);
    }

    private ItemNode mergeSortByPrice(ItemNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;
        ItemNode left = mergeSortByPrice(head);
        ItemNode right = mergeSortByPrice(nextOfMiddle);
        return mergeByPrice(left, right);
    }

    private ItemNode getMiddle(ItemNode head) {
        if (head == null) {
            return head;
        }
        ItemNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ItemNode mergeByName(ItemNode left, ItemNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.itemName.compareTo(right.itemName) <= 0) {
            left.next = mergeByName(left.next, right);
            return left;
        } else {
            right.next = mergeByName(left, right.next);
            return right;
        }
    }

    private ItemNode mergeByPrice(ItemNode left, ItemNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.price <= right.price) {
            left.next = mergeByPrice(left.next, right);
            return left;
        } else {
            right.next = mergeByPrice(left, right.next);
            return right;
        }
    }

    public void displayAllItems() {
        ItemNode current = head;
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", Item ID: " + current.itemID + ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addAtBeginning("Laptop", 101, 10, 800);
        inventory.addAtEnd("Mouse", 102, 25, 20);
        inventory.addAtEnd("Keyboard", 103, 15, 40);

        inventory.displayAllItems();

        inventory.addAtPosition("Monitor", 104, 5, 150, 2);

        inventory.displayAllItems();

        inventory.removeByItemID(102);

        inventory.displayAllItems();

        inventory.updateQuantityByItemID(101, 12);

        inventory.displayAllItems();

        System.out.println("Total Inventory Value: " + inventory.calculateTotalValue());

        inventory.sortByItemName();

        inventory.displayAllItems();

        inventory.sortByPrice();

        inventory.displayAllItems();
    }
}
