package lesson9.shapes;

public class ShapesDemo {
    public static void main(String[] args) {
        Circle circle1 = new Circle("Green", 3, 4, 6);
        Circle circle2 = new Circle("Red", 6, 9, 56);
        Circle circle3 = new Circle("Red", 6, 9, 56);
        Rectangle rectangle1 = new Rectangle("Black", 4, 5, 6, 7);
        Rectangle rectangle2 = new Rectangle("White", 5, 6, 7, 8);
        Shape[] shapes = {circle1, circle2, circle3, rectangle1, rectangle2};
        for (Shape shape : shapes) {
            shape.draw();
        }

        System.out.println(circle1.equals(circle2));
        System.out.println(circle2.equals(circle3));

        System.out.println(circle1);
        System.out.println(rectangle1);
    }
}
