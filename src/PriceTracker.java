import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceTracker {
    static Map<String, List<Double>> sales =  new HashMap<>();

    public static void trackPrice(String product, double price) {
        sales.computeIfAbsent(product, k -> new ArrayList<>()).add(price);
    }

    public static double getAvgPrice(String product) {
        return avg(sales.get(product));
    }

    public static double getHighestPrice(String product) {
        List<Double> prices = sales.get(product);
        double highestPrice = prices.get(0);
        for(double price: prices) {
            if(price > highestPrice) {
                highestPrice = price;
            }
        }
        return highestPrice;
    }

    public static double getLowestPrice(String product) {
        List<Double> prices = sales.get(product);
        double lowestPrice = prices.get(0);
        for(double price: prices) {
            if(price < lowestPrice) {
                lowestPrice = price;
            }
        }
        return lowestPrice;
    }

    public static Order priceOrder(Order order) {
        for(String product: order.order.keySet()) {
            order.price += getAvgPrice(product) * order.order.get(product);
            order.prices.putIfAbsent(product, getAvgPrice(product));
        }
        return order;
    }

    public static List<String> getListOfProducts() {
        return new ArrayList<>(sales.keySet());
    }

    public static double getPriceOfRecipe(Recipe recipe) {
        Map<String, Integer> count = recipe.count();
        double sum = 0d;
        for(String product: count.keySet()) {
            sum += getAvgPrice(product);
        }
        return sum;
    }

    private static double avg(List<Double> prices) {
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        return sum / prices.size();
    }

    public String toString() {
        return sales.toString();
    }


}
