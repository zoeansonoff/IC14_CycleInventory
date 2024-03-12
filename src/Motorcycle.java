import java.io.Serializable;
import java.util.Objects;

public class Motorcycle extends Cycle implements Serializable {
    public Motorcycle(String manufacturer, double price, int displacement, double fuelCapacity) {
        super(manufacturer, price);
        this.displacement = displacement;
        this.fuelCapacity = fuelCapacity;
    }
    private int displacement;


    private double fuelCapacity;
//make getter and setter here

    public int getDisplacement() {
        return displacement;
    }


    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }


    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
    //make an equals here

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return displacement == that.displacement && Double.compare(fuelCapacity, that.fuelCapacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(displacement, fuelCapacity);
    }
    //make a toString here

    @Override
    public String toString() {
        return "Motorcycle[" +
                "manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", displacement=" + displacement +
                ", fuelCapacity=" + fuelCapacity +
                ']';
    }
}
