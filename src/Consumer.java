import java.util.List;

public interface Consumer {
    default void receive(Transporter transporter) {
        Inventory inventory = getInventory();
        while(!transporter.isEmpty()) {
            inventory.inventory.add(transporter.unload());
            inventory.inventory.getLast().destination = null;
        }
    }

    Inventory getInventory();
    Factory getFactory();
}
