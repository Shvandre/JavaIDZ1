package org.example;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {
    private final List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAllAnimals() {
        return animals;
    }
}
