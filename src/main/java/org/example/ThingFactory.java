package org.example;

import org.springframework.stereotype.Component;
import java.util.Random;
@Component
public class ThingFactory {

    public Thing createThing(String type) {
        switch (type.toLowerCase()) {
            case "table":
                return new Table();
            case "computer":
                return new Computer();
            default:
                throw new IllegalArgumentException("Неизвестный тип предмета: " + type);
        }
    }
}

