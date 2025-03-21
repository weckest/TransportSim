public class Product {

    String name;
    boolean ship;

    public Product() {
        name = "Base";
        ship = true;
    }

    public Product(String name) {
        this.name = name;
        ship = true;
    }

    public boolean equals(Product p) {
        return this.name.equals(p.name);
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }

    public String toString() {
        return name;
    }
}
