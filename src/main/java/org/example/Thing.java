package org.example;

abstract public class Thing implements IInventory {
    private int number;
    @Override
    final public void setNumber(int number) {
        this.number = number;
    }

    @Override
    final public int getNumber() {
        return number;
    }
}
