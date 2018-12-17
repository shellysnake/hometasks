package lesson8.animals;

import java.util.Objects;

public class Horse extends Animal {
    private int age;

    public Horse(String food, String location, int age) {
        super(food, location);
        this.age = age;
    }

    public Horse() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        return "Horse{" +
                "age=" + age +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Horse horse = (Horse) o;
        return age == horse.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }
}
