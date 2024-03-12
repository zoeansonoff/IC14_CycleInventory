import java.io.Serializable;

public abstract class Cycle implements Serializable {
    protected String manufacturer;
    protected double price;

//accessors/mutators mean to generate getters/setters, generate them here for each
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    protected Cycle(String manufacturer, double price) {
        this.manufacturer = manufacturer;
        this.price = price;
    }




}
