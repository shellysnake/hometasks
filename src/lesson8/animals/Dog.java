package lesson8.animals;

import java.util.Objects;

public class Dog extends Animal {
    private String nickname;

    public Dog(String food, String location, String nickname) {
        super(food, location);
        this.nickname = nickname;
    }

    public Dog() {

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
        return "Dog{" +
                "nickname='" + nickname + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(nickname, dog.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nickname);
    }
}
