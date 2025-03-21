public class Producer implements Inventory {
    Recipe recipe;

    public Producer() {

    }

    public Producer(Recipe r) {
        recipe = r;
    }

    void produce() {
        if(recipe == null) {
            throw new NullPointerException("Recipe is null");
        }

        if (this.contains(recipe)) {
            System.out.println("Making: " + recipe.result);
            this.remove(recipe);
            inventory.add(new Product(recipe.result));
        }
    }

    void load(Transporter transporter) {
        for(int i = 0; i < inventory.size(); i++) {
            Product product = inventory.getLast();
            if(product.ship) {
                inventory.remove(product);
                transporter.load(product);
            }
        }
    }

    public String toString() {
        String output = "Inventory: \n";
        for(Product p : inventory) {
            output += p.toString() + "\n";
        }
        return output;
    }
}
