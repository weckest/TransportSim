import java.util.ArrayList;
import java.util.List;

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
        for(Product p : products) {
            if(p.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String output = result + ": ";
        for(int i = 0; i < products.size(); i++) {
            output += products.get(i).name + ": " + amounts.get(i) + "\n";
        }
        return output;
    }
}
