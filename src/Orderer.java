public interface Orderer {

    default void makeOrder(Consumer consumer) {
        Order o = new Order();
        Inventory i = getInventory();
        Recipe r = getRecipe();
        o.order.putAll(i.getMissingItems(r));
        System.out.println("new order: " + o.order);
        OrderTracker.addOrder(consumer, o);
    }

    Inventory getInventory();
    Recipe getRecipe();
}
