import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PriceTracker tracker = new PriceTracker();
//        PriceTracker.trackPrice("Wood", 5d);
//        PriceTracker.trackPrice("Wood", 3d);
//        PriceTracker.trackPrice("Metal", 10d);
//        System.out.println(tracker);

//        System.out.println(PriceTracker.getAvgPrice("Wood"));
//        System.out.println(PriceTracker.getHighestPrice("Wood"));
//        System.out.println(PriceTracker.getLowestPrice("Wood"));
        RecipeBuilder rb = new RecipeBuilder();
//
//        List<Recipe> recipes = new ArrayList<>();
//
//        recipes.add(rb.build("Wood"));
//        recipes.add(rb.build( "Metal"));
//        recipes.add(rb.build(new Product[]{new Product("Wood")}, new int[]{2}, "Table"));
        Recipe wood = rb.build("Wood");
        Recipe metal = rb.build("Metal");
        Recipe table = rb.build(new Product[]{new Product("Wood")}, new int[]{2}, "Table");
//
//        List<Factory> factories = FactoryBuilder.build(4, recipes);
//
//        Transporter t = new Transporter();
//
//        for(Factory f : factories) {
//            f.receive(t);
//            try {
//                f.produce();
//                f.load(t);
//            } catch (Exception e) {}
//        }

        Consumer c = new Factory();
        Producer p1 = new Factory(wood);
        Producer p2 = new Factory(metal);
        Factory f = new Factory(table);
        Transporter t = new Transporter();
//

        f.produce();
        f.load(t);
        c.receive(t);



    }
}