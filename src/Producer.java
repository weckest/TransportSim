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
        inventory.inventory.add(new Product(recipe.result));
    }

    default void load(Transporter transporter) {
        List<Product> inventory = getInventory().inventory;
        Recipe recipe = getRecipe();
        for(int i = inventory.size() - 1; i >= 0; i--) {
            Product product = inventory.get(i);
            if(!recipe.needs(product)) {
                inventory.remove(product);
                transporter.load(product);
            }
        }
    }

    Inventory getInventory();
    Recipe getRecipe();
}
