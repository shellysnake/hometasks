package lesson8.flowers;

import java.util.Objects;

public class Carnation extends Flower {
    private String type;

    public Carnation(String producingCountry, int storageTime, double price, String type) {
        super(producingCountry, storageTime, price);
        this.type = type;
    }

    public Carnation() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Carnation{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Carnation carnation = (Carnation) o;
        return Objects.equals(type, carnation.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
