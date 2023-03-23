package oopExamples.oopExample7;

import java.util.ArrayList;

public class Zoo {
    private ArrayList<Animal> animals;

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void printAnimals() {
        animals.forEach(System.out::println);
    }
}
