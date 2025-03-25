import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
    List<Product> products;
    List<Integer> amounts;
    String result;

    public Recipe() {
        products = new ArrayList<Product>();
        amounts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addAmount(int amount) {
        amounts.add(amount);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean hasEnough(Product product, int amount) {
        boolean flag = true;
        if(amount == 0) {
            return false;
        }
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).equals(product)) {
                flag = (amount - amounts.get(i) >= 0);
            }
            if(!flag) {
                return flag;
            }
        }
        return flag;
    }

    public boolean needs(Product product) {
        return needs(product.name);
    }

    public boolean needs(String product) {
        for(Product p : products) {
            if(p.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public int amountNeeded(Product product) {
        return amountNeeded(product.name);
    }

    public int amountNeeded(String product) {
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).equals(product)) {
                return amounts.get(i);
            }
        }
        return 0;
    }

    public Map<String, Integer> count() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < products.size(); i++) {
            map.put(products.get(i).name, amounts.get(i));
        }
        return map;
    }

    public String toString() {
        String output = result + ": ";
        for(int i = 0; i < products.size(); i++) {
            output += products.get(i).name + ": " + amounts.get(i) + "\n";
        }
        return output;
    }
}
