import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    Map<String, Integer> order;
    Map<String, Double> prices;
    int orderId;
    double price;


    public Order() {
        orderId = OrderTracker.orders();
        order = new HashMap<>();
        prices = new HashMap<>();
    }

    public boolean orderFor(Product product) {
        return order.containsKey(product.name);
    }

    public double fulfillOrder(Product product) {
        order.replace(product.name, order.get(product.name) - 1);
        if(order.get(product.name) == 0) {
            order.remove(product.name);
            checkCompletion();
        }
        PriceTracker.trackPrice(product.name, prices.get(product.name));
        return prices.get(product.name);
    }

    private void checkCompletion() {
        if(order.isEmpty()) {
            System.out.println("Order: " + orderId + " complete");
            OrderTracker.removeOrder(this);
        }
    }

    public boolean equals(Order o) {
        return orderId == o.orderId;
    }

    public String toString() {
        return "Order: " + order.toString() + ", Total: $" + price;
    }
}
