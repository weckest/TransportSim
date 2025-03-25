public class Product {

    String name;
    Consumer destination;

    public Product() {
        name = "Base";
    }

    public Product(String name) {
        this.name = name;
    }

    public void setDestination(Consumer destination) {
        System.out.println(name + " destination set");
        this.destination = destination;
    }

    public boolean equals(Product p) {
        return equals(p.name);
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }

    public String toString() {
        return name;
    }
}
