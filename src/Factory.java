import java.util.ArrayList;
import java.util.List;

public class Factory implements Consumer, Producer, Orderer {
    Recipe recipe;
    Inventory inventory;
    Account account;

    public Factory() {
        inventory = new Inventory();
        account = new Account();
    }

    public Factory(Recipe r) {
        this.recipe = r;
        inventory = new Inventory();
        account = new Account();
    }

    @Override
    public void receive(Transporter transporter) {
        Consumer.super.receive(transporter);
        load(transporter);
    }


    public void produce() {
        if(inventory.contains(recipe)) {
            Producer.super.produce();
        } else {
            System.out.println("not enough to make: " + recipe.result);
            makeOrder(this);
            /*Order o = new Order();
            System.out.println("Making Order: " +  inventory.getMissingItems(recipe));
            o.order.putAll(inventory.getMissingItems(recipe));
            OrderTracker.addOrder(this, o); */
        }
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public Factory getFactory() {
        return this;
    }

    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public Account getAccount() {
        return account;
    }
}
