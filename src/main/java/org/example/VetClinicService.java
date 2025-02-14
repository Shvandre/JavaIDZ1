package org.example;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class VetClinicService {
    public boolean checkHealth(Animal animal) {
        return new Random().nextDouble() < 0.8;
    }
}
