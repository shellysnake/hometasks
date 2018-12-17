package lesson9.fruits;

public class FruitsDemo {
    public static void main(String[] args) {
        Apple apple1 = new Apple(2.5, 25);
        Pear pear1 = new Pear(1.5, 45);
        Apricot apricot1 = new Apricot(5.5, 70);
        Apricot apricot2 = new Apricot(3.5, 40);
        Apricot apricot3 = new Apricot(1.5, 90);

        System.out.println(apple1.getFruitPrice());
        System.out.println(pear1.getFruitPrice());
        System.out.println(apricot1.getFruitPrice());
        System.out.println(apricot2.getFruitPrice());
        System.out.println(Fruit.costOfFruits);
    }
}
