import java.util.ArrayList;
import java.util.List;

public class Factory extends Producer implements Consumer {

    public Factory() {

    }

    public Factory(Recipe r) {
        super(r);
    }

    @Override
    public void receive(Transporter transporter) {
        if(recipe == null) {
            Consumer.super.receive(transporter);
        } else {
            while (!transporter.isEmpty()) {
                Product p = transporter.unload();
                if (recipe.needs(p)) {
                    p.ship = false;
                }
                inventory.add(p);
            }
            load(transporter);
        }
    }
}
