import java.util.List;

public interface Orderer {

    default void makeOrder(Consumer consumer) {
        Order o = new Order();
        Inventory i = getInventory();
        Recipe r = getRecipe();
        if(r != null) {
            o.order.putAll(i.getMissingItems(r));
            PriceTracker.priceOrder(o);
            System.out.println("new: " + o);
            getAccount().money -= o.price;
            OrderTracker.addOrder(consumer, o);
        } else {
            List<String> products = PriceTracker.getListOfProducts();
            for(String product : products) {
                Order order = new Order();
                order.order.putIfAbsent(product, 1);
                PriceTracker.priceOrder(order);
                System.out.println("new: " + order);
                getAccount().money -= o.price;
                OrderTracker.addOrder(consumer, order);
            }

        }
    }

    Inventory getInventory();
    Recipe getRecipe();
    Account getAccount();
}
