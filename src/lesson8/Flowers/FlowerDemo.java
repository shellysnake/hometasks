package lesson8.Flowers;

public class FlowerDemo {
    public static void main(String[] args) {
        Rose rose1 = new Rose("UK", 5, 50, "Red");
        Rose rose2 = new Rose("Ukraine", 4, 100, "Yellow");
        Carnation carnation1 = new Carnation("Germany", 10, 180, "Type1");
        Carnation carnation2 = new Carnation("Ukraine", 8, 110, "Type2");
        Tulip tulip1 = new Tulip("Ukraine", 3, 40, 5.5);
        Tulip tulip2 = new Tulip("Ukraine", 4, 45, 4.5);
        Flower[] flowers1 = {rose1, carnation1, tulip1};
        Flower[] flowers2 = {rose2, carnation2, tulip2};
        int price = 0;
        for (Flower flower : flowers1) {
            price += flower.getPrice();
        }
        System.out.println("Цена первого букета " + price);
        price = 0;
        for (Flower flower : flowers2) {
            price += flower.getPrice();
        }
        System.out.println("Цена второго букета " + price);
        System.out.println("Всего продано цветов: " + Flower.k);
    }
}
