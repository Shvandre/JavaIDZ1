package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    private InventoryRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InventoryRepository();
    }

    @Test
    void whenAddInventoryItem_thenCanRetrieveIt() {
        // Arrange
        Thing thing = new Table();

        // Act
        repository.addInventoryItem(thing);

        // Assert
        assertTrue(repository.getAllInventory().contains(thing));
        assertEquals(1, repository.getAllInventory().size());
    }

    @Test
    void whenRepositoryEmpty_thenListIsEmpty() {
        // Assert
        assertTrue(repository.getAllInventory().isEmpty());
    }
} 