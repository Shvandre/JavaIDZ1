package org.example;

import org.springframework.stereotype.Component;
import java.util.Random;
@Component
public class AnimalFactory {

    public Animal createAnimal(String type) {
        switch (type.toLowerCase()) {
            case "monkey":
                return new Monkey();
            case "rabbit":
                return new Rabbit();
            case "wolf":
                return new Wolf();
            case "tiger":
                return new Tiger();
            default:
                throw new IllegalArgumentException("Неизвестный тип предмета: " + type);
        }
    }
}


