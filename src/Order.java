import java.util.HashMap;
import java.util.Map;

public class Order {
    Map<String, Integer> order;
    int orderId;


    public Order() {
        orderId = OrderTracker.orders();
        order = new HashMap<String, Integer>();
    }

    public boolean orderFor(Product product) {
        return order.containsKey(product.name);
    }

    public void fulfillOrder(Product product) {
//        System.out.println("Order: " + order);
        order.replace(product.name, order.get(product.name) - 1);
        if(order.get(product.name) == 0) {
            order.remove(product.name);
            checkCompletion();
        }
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
}
