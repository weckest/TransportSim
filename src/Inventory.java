import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Inventory {
    List<Product> inventory = new ArrayList<>();

    public boolean contains(Recipe recipe) {
        boolean flag = recipe.count().isEmpty();
        Map<String, Integer> count = count();
        for(int i = 0; i < inventory.size(); i++) {
            flag = recipe.hasEnough(inventory.get(i), count.get(inventory.get(i).name));
            if(!flag) {
                return flag;
            }
        }
        return flag;
    }

    public Map<String, Integer> getMissingItems(Recipe recipe) {
        Map<String, Integer> count = recipe.count();
        for(Product p : inventory) {
            if(count.containsKey(p.name)) {
                count.replace(p.name, count.get(p.name) - 1);
                if(count.get(p.name) == 0) {
                    count.remove(p.name);
                }
            }
        }
        return count;
    }

    public Map<String, Integer> count() {
        Map<String, Integer> counts = new HashMap<>();
        for(Product p : inventory) {
            counts.put(p.name, counts.getOrDefault(p.name, 0) + 1);
        }
        System.out.println(counts);
        return counts;
    }

    public void remove(Recipe recipe) {
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
