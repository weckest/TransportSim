import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderTracker {
    private static Map<Consumer, List<Order>> orders = new HashMap<>();

    public static void addOrder(Consumer consumer, Order order) {
        orders.computeIfAbsent(consumer, k -> new ArrayList<>()).add(order);
    }

    public static Map<Consumer, List<Order>> getOrdersForProduct(Product product) {
        Map<Consumer, List<Order>> ordersForProduct = new HashMap<>();
        for(Consumer consumer : orders.keySet()) {
            for(Order order : orders.get(consumer)) {
                if(order.orderFor(product)) {
                    ordersForProduct.computeIfAbsent(consumer, k -> new ArrayList<>()).add(order);
                }
            }
        }
        return ordersForProduct;
    }

    public String toString() {
        return orders.toString();
    }

}
