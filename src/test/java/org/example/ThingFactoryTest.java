package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ThingFactoryTest {
    
    private final ThingFactory factory = new ThingFactory();

    @Test
    void createThing_withValidTypes_returnsCorrectInstances() {
        // Act & Assert
        assertTrue(factory.createThing("table") instanceof Table);
        assertTrue(factory.createThing("computer") instanceof Computer);
    }

    @Test
    void createThing_withInvalidType_throwsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, 
            () -> factory.createThing("invalid"));
    }
} 