import java.util.ArrayList;
import java.util.List;

public class Transporter {
    List<Product> cargo;

    public Transporter() {
        cargo = new ArrayList<Product>();
    }

    public void load(Product product) {
        cargo.add(product);
        System.out.println("(load) " + product + " Cargo Capacity: " + cargo.size());
    }

    public Product unload() {
        Product p = cargo.getLast();
        cargo.remove(p);
        System.out.println("(unload) " + p + " Cargo Capacity: " + cargo.size());
        return p;
    }

    public boolean contains(String name) {
        for(Product p : cargo) {
            if(p.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return cargo.isEmpty();
    }
}
