import java.util.ArrayList;
import java.util.List;

public interface Consumer extends Inventory{
    default void receive(Transporter transporter) {
        while(!transporter.isEmpty()) {
            inventory.add(transporter.unload());
        }
    }

    default void sell() {

    }
}
