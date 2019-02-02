package lesson16.pet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PetDemo {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("Dog1", new Dog());
        petMap.put("Cat1", new Cat());
        petMap.put("Parrot", new Parrot());
        petMap.put("Dog2", new Dog());
        petMap.put("Cat2", new Cat());
        showPetNames(petMap);
    }

    public static void showPetNames(Map<String, Pet> petMap) {
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            System.out.println(name);
        }
    }
}
