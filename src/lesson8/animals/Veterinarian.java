package lesson8.animals;

public class Veterinarian {

    public void treatAnimal(Animal animal) {
        System.out.println("На прием пришел " + animal.getFood() + ", " + animal.getLocation());
    }
}
