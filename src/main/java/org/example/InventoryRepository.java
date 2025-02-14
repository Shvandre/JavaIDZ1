package org.example;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class InventoryRepository {
    private final List<IInventory> inventory = new ArrayList<>();

    public void addInventoryItem(IInventory item) {
        inventory.add(item);
    }

    public List<IInventory> getAllInventory() {
        return inventory;
    }
}