package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryTest {

    private AnimalRepository repository;

    @BeforeEach
    void setUp() {
        repository = new AnimalRepository();
    }

    @Test
    void whenAddAnimal_thenCanRetrieveIt() {
        // Arrange
        Animal animal = new Rabbit();

        // Act
        repository.addAnimal(animal);

        // Assert
        assertTrue(repository.getAllAnimals().contains(animal));
        assertEquals(1, repository.getAllAnimals().size());
    }

    @Test
    void whenRepositoryEmpty_thenListIsEmpty() {
        // Assert
        assertTrue(repository.getAllAnimals().isEmpty());
    }
} 