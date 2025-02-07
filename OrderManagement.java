class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered";
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        Order order = new Order(1001, "2025-02-01");
        ShippedOrder shippedOrder = new ShippedOrder(1002, "2025-02-02", "TRK123456");
        DeliveredOrder deliveredOrder = new DeliveredOrder(1003, "2025-02-03", "TRK789101", "2025-02-06");

        System.out.println("Order ID: " + order.orderId + ", Status: " + order.getOrderStatus());
        System.out.println("Order ID: " + shippedOrder.orderId + ", Status: " + shippedOrder.getOrderStatus());
        System.out.println("Order ID: " + deliveredOrder.orderId + ", Status: " + deliveredOrder.getOrderStatus());
    }
}
