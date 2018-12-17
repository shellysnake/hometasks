package lesson9.shapes;

import java.util.Objects;

public class Rectangle extends Shape {
    private int x, y, z, c;

    public Rectangle(String color, int x, int y, int z, int c) {
        super(color);
        this.x = x;
        this.y = y;
        this.z = z;
        this.c = c;
    }

    public Rectangle(int x, int y, int z, int c) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public void draw() {
        System.out.println("Рисую прямоугольник с координатами " + getX() + ", " + getY() +
                ", " + getZ() + ", " + getC() + " и цветом " + getColor());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", c=" + c +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return x == rectangle.x &&
                y == rectangle.y &&
                z == rectangle.z &&
                c == rectangle.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x, y, z, c);
    }
}
