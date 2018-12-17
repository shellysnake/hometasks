package lesson9.circle;

public class CircleDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Circle circle1 = new Circle(8);
        System.out.println("Длинна окружности = " + circle.getCircleLength() + ", " +
                "площадь = " + circle.getAreaOfCircle());
        System.out.println("Длинна окружности = " + circle1.getCircleLength() + ", " +
                "площадь = " + circle1.getAreaOfCircle());
    }
}
