package lesson10.instrument;

import java.util.Objects;

public class Trumpet implements Instrument {
    private double diameter;

    public Trumpet(double diameter) {
        this.diameter = diameter;
    }

    public Trumpet() {
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public void play() {
        System.out.println("Играет труба с диаметром: " + getDiameter());
    }

    @Override
    public String toString() {
        return "Trumpet{" +
                "diameter=" + diameter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trumpet trumpet = (Trumpet) o;
        return Double.compare(trumpet.diameter, diameter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter);
    }
}
