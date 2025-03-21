import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public interface Inventory {
    List<Product> inventory = new ArrayList<>();

    default boolean contains(Recipe recipe) {
        boolean flag = true;
        Map<String, Integer> count = count();
        for(int i = 0; i < inventory.size(); i++) {
            flag = recipe.hasEnough(inventory.get(i), count.get(inventory.get(i).name));
            if(!flag) {
                return flag;
            }
        }
        return flag;
    }

    default Map<String, Integer> count() {
        Map<String, Integer> counts = new HashMap<>();
        for(Product p : inventory) {
            counts.put(p.name, counts.getOrDefault(p.name, 0) + 1);
        }
        System.out.println(counts);
        return counts;
    }

    default void remove(Recipe recipe) {
        for(Product p : recipe.products) {
            for(int i = 0; i < inventory.size(); i++) {
                if(inventory.get(i).equals(p)) {
                    inventory.remove(i);
                    break;
                }
            }
        }
    }
}
