import java.io.Serializable;
import java.util.Objects;

public class Bicycle extends Cycle implements Serializable {
//generate constructor
    public Bicycle(String manufacturer, double price, int frameSize, int cranks) {
        super(manufacturer, price);
        this.frameSize = frameSize;
        this.cranks = cranks;
    }
    //accessors/mutators mean to generate getters/setters, generate them here for each
    private int frameSize;

    public int getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(int frameSize) {
        this.frameSize = frameSize;
    }
    private int cranks;

    public int getCranks() {
        return cranks;
    }

    public void setCranks(int cranks) {
        this.cranks = cranks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return frameSize == bicycle.frameSize && cranks == bicycle.cranks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(frameSize, cranks);
    }

    @Override
    public String toString() {
        return "Bicycle[" +
                "manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", frameSize=" + frameSize +
                ", cranks=" + cranks +

                ']';
    }
}
