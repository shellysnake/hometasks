package lesson8.animals;

public class AnimalsDemo {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Fish", "Ukraine", "Black");
        cat1.makeNoise();
        cat1.eat();
        cat1.sleep();
        Dog dog1 = new Dog("Bones", "Kharkiv", "Doggy");
        Horse horse1 = new Horse("Grass", "Kharkiv", 9);
        Veterinarian veterinarian1 = new Veterinarian();

        Animal[] animals = {cat1, dog1, horse1};
        for (Animal animal : animals) {
            veterinarian1.treatAnimal(animal);
        }
    }
}
