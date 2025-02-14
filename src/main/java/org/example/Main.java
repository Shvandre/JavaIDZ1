package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ZooService zooService = initializeServices();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nДоступные команды:");
            System.out.println("  add-animal <тип> <номер> <еда> [доброта]");
            System.out.println("  add-thing <тип> <номер>");
            System.out.println("  food-report");
            System.out.println("  contact-zoo");
            System.out.println("  inventory");
            System.out.println("  exit");
            
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine().trim();
            
            if (input.equals("exit")) {
                break;
            }
                                                    // Split the input string by whitespaces/tabs (one or more)
            String[] command = input.split("\\s+");
            
            switch (command[0]) {
                case "add-animal":
                    handleAddAnimal(command, zooService);
                    break;
                case "add-thing":
                    handleAddThing(command, zooService);
                    break;
                case "food-report":
                    zooService.printFoodReport();
                    break;
                case "contact-zoo":
                    zooService.printContactZooAnimals();
                    break;
                case "inventory":
                    zooService.printInventory();
                    break;
                default:
                    System.out.println("Неизвестная команда: " + command[0]);
            }
        }
        
        scanner.close();
    }

    private static void handleAddAnimal(String[] args, ZooService zooService) {
        if (args.length < 4) {
            System.out.println("Недостаточно аргументов для добавления животного");
            return;
        }

        AnimalFactory factory = new AnimalFactory();
        Animal animal = factory.createAnimal(args[1]);
        animal.setNumber(Integer.parseInt(args[2]));
        animal.setFood(Integer.parseInt(args[3]));

        if (animal instanceof Herbo && args.length > 4) {
            ((Herbo) animal).setKindness(Integer.parseInt(args[4]));
        }

        zooService.addAnimal(animal);
    }

    private static void handleAddThing(String[] args, ZooService zooService) {
        if (args.length < 3) {
            System.out.println("Недостаточно аргументов для добавления предмета");
            return;
        }

        ThingFactory factory = new ThingFactory();
        Thing thing = factory.createThing(args[1]);
        thing.setNumber(Integer.parseInt(args[2]));
        zooService.addInventory(thing);
    }
    // Эта функция работает как DI контейнер - она создаёт нужные для работы сервисы и передаёт их в конструктор ZooService
    private static ZooService initializeServices() {
        AnimalRepository animalRepository = new AnimalRepository();
        InventoryRepository inventoryRepository = new InventoryRepository();
        VetClinicService vetClinicService = new VetClinicService();
        return new ZooService(animalRepository, inventoryRepository, vetClinicService);
    }
}