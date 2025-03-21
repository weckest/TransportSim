import java.util.ArrayList;
import java.util.List;

public class FactoryBuilder {

    public static List<Factory> build(int factories, List<Recipe> recipes) {
        List<Factory> factoriesList = new ArrayList<Factory>();
        for(int i = 0; i < factories; i++) {
            if(i >= recipes.size()) {
                factoriesList.add(new Factory());
            } else {
                factoriesList.add(new Factory(recipes.get(i)));
            }
        }
        return factoriesList;
    }
}
