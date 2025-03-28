import java.util.List;

public interface Consumer {
    default void receive(Transporter transporter) {
        Inventory inventory = getInventory();
        while(!transporter.isEmpty()) {
            inventory.inventory.add(transporter.unload());
            if(getFactory() == inventory.inventory.getLast().destination) {
                inventory.inventory.getLast().destination = null;
            }
        }
        if(getRecipe() == null) {
            getFactory().makeOrder(this);
        }
    }

    Inventory getInventory();
    Recipe getRecipe();
    Factory getFactory();
    Account getAccount();
}
