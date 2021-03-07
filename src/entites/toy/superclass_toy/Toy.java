package entites.toy.superclass_toy;

public class Toy {
    private int id;
    private String name;
    private int price;
    private String manufacturer;
    private int quantity;

    public Toy(int id, String name, int price, String manufacturer, int quantity) { // construct of the class
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

    public Toy() { // construct of the class

    }

    public Toy(String name, int price, String manufacturer, int quantity) { // construct of the class
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }
    // setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantity=" + quantity +
                '}'+"\n";
    }
}
