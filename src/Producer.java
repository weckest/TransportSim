import java.util.List;
import java.util.Map;

public interface Producer {


    default void produce() {
        Inventory inventory = getInventory();
        Recipe recipe = getRecipe();

        if (recipe == null) {
            throw new NullPointerException("Recipe is null");
        }

        System.out.println("Making: " + recipe.result);
        inventory.remove(recipe);
        Product p = new Product(recipe.result);
        if(!recipe.products.isEmpty()) {
            PriceTracker.trackPrice(p.name, PriceTracker.getPriceOfRecipe(recipe) * 1.5);
        }
        inventory.inventory.add(p);

        Map<Consumer, List<Order>> orders = OrderTracker.getOrdersForProduct(p);
        if(!orders.isEmpty()) {
            Order best = orders.get(orders.keySet().iterator().next()).get(0);
            Consumer consumer = orders.keySet().iterator().next();
            for (Consumer c : orders.keySet()) {
                Order temp = MoneyBrain.mostExpensiveOrder(orders.get(c));
                if (temp.price > best.price) {
                    consumer = c;
                    best = temp;
                }
            }

            getAccount().money += best.fulfillOrder(p);
            p.setDestination(consumer);
        }

    }

    default void load(Transporter transporter) {
        List<Product> inventory = getInventory().inventory;
        for(int i = inventory.size() - 1; i >= 0; i--) {
            Product product = inventory.get(i);
            if(product.destination != null) {
                inventory.remove(product);
                transporter.load(product);
            }
        }
    }

    Inventory getInventory();
    Recipe getRecipe();
    Account getAccount();
}
