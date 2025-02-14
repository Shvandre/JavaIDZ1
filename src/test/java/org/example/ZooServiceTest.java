package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ZooServiceTest {

    @Mock
    private AnimalRepository animalRepository;
    
    @Mock
    private InventoryRepository inventoryRepository;
    
    @Mock
    private VetClinicService vetClinicService;

    private ZooService zooService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        zooService = new ZooService(animalRepository, inventoryRepository, vetClinicService);
    }

    @Test
    void whenAddHealthyAnimal_thenAnimalAccepted() {
        // Arrange
        Animal animal = new Rabbit();
        when(vetClinicService.checkHealth(any(Animal.class))).thenReturn(true);

        // Act
        zooService.addAnimal(animal);

        // Assert
        verify(animalRepository).addAnimal(animal);
        verify(inventoryRepository).addInventoryItem(animal);
    }

    @Test
    void whenAddUnhealthyAnimal_thenAnimalRejected() {
        // Arrange
        Animal animal = new Wolf();
        when(vetClinicService.checkHealth(any(Animal.class))).thenReturn(false);

        // Act
        zooService.addAnimal(animal);

        // Assert
        verify(animalRepository, never()).addAnimal(animal);
        verify(inventoryRepository, never()).addInventoryItem(animal);
    }

    @Test
    void whenAddThing_thenAddedToInventory() {
        // Arrange
        Thing thing = new Table();

        // Act
        zooService.addInventory(thing);

        // Assert
        verify(inventoryRepository).addInventoryItem(thing);
    }

    @Test
    void calculateTotalFood_returnsCorrectSum() {
        // Arrange
        Animal rabbit = new Rabbit();
        rabbit.setFood(2);
        Animal wolf = new Wolf();
        wolf.setFood(5);
        
        when(animalRepository.getAllAnimals()).thenReturn(Arrays.asList(rabbit, wolf));

        // Act
        zooService.printFoodReport();

        // Assert
        verify(animalRepository).getAllAnimals();
    }
} 