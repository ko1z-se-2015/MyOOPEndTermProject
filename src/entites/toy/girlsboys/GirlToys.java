package entites.toy.girlsboys;

import entites.toy.superclass_toy.Toy;

public class GirlToys extends Toy { // this class extends the class Toy
    public GirlToys(int id, String name, int price, String manufacturer, int quantity) { // construct of the class
        super(id, name, price, manufacturer, quantity);
    }

    public GirlToys() { // construct of the class
    }

    public GirlToys(String name, int price, String manufacturer, int quantity) { // construct of the class
        super(name, price, manufacturer, quantity);
    }
    // setters and getters
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @Override
    public String getManufacturer() {
        return super.getManufacturer();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        super.setManufacturer(manufacturer);
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
