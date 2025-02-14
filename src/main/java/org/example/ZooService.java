package org.example;

import org.springframework.stereotype.Service;

@Service
public class ZooService {
    private final AnimalRepository animalRepository;
    private final InventoryRepository inventoryRepository;
    private final VetClinicService vetClinicService;

    public ZooService(AnimalRepository animalRepository, InventoryRepository inventoryRepository, VetClinicService vetClinicService) {
        this.animalRepository = animalRepository;
        this.inventoryRepository = inventoryRepository;
        this.vetClinicService = vetClinicService;
    }

    public void addAnimal(Animal animal) {
        if (isAnimalHealthy(animal)) {
            acceptAnimal(animal);
        } else {
            rejectAnimal(animal);
        }
    }

    private boolean isAnimalHealthy(Animal animal) {
        return vetClinicService.checkHealth(animal);
    }

    private void acceptAnimal(Animal animal) {
        animalRepository.addAnimal(animal);
        inventoryRepository.addInventoryItem(animal);
        System.out.println(animal.toString() + " accepted into the zoo!");
    }

    private void rejectAnimal(Animal animal) {
        System.out.println(animal.toString() + " did not pass the health check.");
    }

    public void addInventory(Thing thing) {
        inventoryRepository.addInventoryItem(thing);
    }

    public void printFoodReport() {
        int totalFood = calculateTotalFood();
        System.out.println("Total food required: " + totalFood + " kg/day.");
    }

    private int calculateTotalFood() {
        return animalRepository.getAllAnimals().stream().mapToInt(IAlive::getFood).sum();
    }

    public void printContactZooAnimals() {
        animalRepository.getAllAnimals().stream()
                .filter(this::isContactZooAnimal)
                .forEach(a -> System.out.println(a + " can be in the petting zoo"));
    }

    private boolean isContactZooAnimal(Animal animal) {
        return animal instanceof Herbo && ((Herbo) animal).getKindness() > 5;
    }

    public void printInventory() {
        inventoryRepository.getAllInventory().forEach(System.out::println);
    }
}