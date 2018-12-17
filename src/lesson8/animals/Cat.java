package lesson8.animals;

import java.util.Objects;

public class Cat extends Animal {
    private String color;

    public Cat(String food, String location, String color) {
        super(food, location);
        this.color = color;
    }

    public Cat() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void sleep() {
        super.sleep();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
