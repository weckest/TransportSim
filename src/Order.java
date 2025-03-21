import java.util.HashMap;
import java.util.Map;

public class Order {
    Map<String, Double> order;


    public Order() {
        order = new HashMap<String, Double>();
    }

    public boolean orderFor(Product product) {
        return order.containsKey(product.name);
    }
}
