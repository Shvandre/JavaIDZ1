package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalFactoryTest {
    
    private final AnimalFactory factory = new AnimalFactory();

    @Test
    void createAnimal_withValidTypes_returnsCorrectInstances() {
        // Act & Assert
        assertTrue(factory.createAnimal("monkey") instanceof Monkey);
        assertTrue(factory.createAnimal("rabbit") instanceof Rabbit);
        assertTrue(factory.createAnimal("wolf") instanceof Wolf);
        assertTrue(factory.createAnimal("tiger") instanceof Tiger);
    }

    @Test
    void createAnimal_withInvalidType_throwsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, 
            () -> factory.createAnimal("invalid"));
    }
} 