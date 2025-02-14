package org.example;

abstract public class Herbo extends Animal implements IKindness {
    private int kindness;
    @Override
    final public void setKindness(int kindness) {
        this.kindness = kindness;
    }
    @Override
    final public int getKindness() {
        return kindness;
    }
}
