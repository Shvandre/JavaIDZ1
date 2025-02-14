package org.example;

abstract public class Animal implements IInventory, IAlive {
    private int food;
    private int number;
    @Override
    final public void setFood(int food) {
        this.food = food;
    }

    @Override
    final public int getFood() {
        return food;
    }

    @Override
    final public void setNumber(int number) {
        this.number = number;
    }

    @Override
    final public int getNumber() {
        return number;
    }
}
