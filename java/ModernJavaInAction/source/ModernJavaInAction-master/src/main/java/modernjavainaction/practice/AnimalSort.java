package modernjavainaction.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnimalSort {
    public static void main(String[] args) {
        ArrayList<Animal> animals = getAnimals();

        Collections.sort(animals,
                Comparator.comparing(Animal::getIntelligenceRate)
                        .thenComparing(Animal::getMusclePower, Comparator.reverseOrder()));


        for (Animal animal : animals) {
            System.out.println(animal.getName() + " " + animal.getIntelligenceRate() + " " + animal.getMusclePower());
        }
    }

    private static ArrayList<Animal> getAnimals() {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Animal("pobi", 9999, 1));
        list.add(new Animal("brown", 9999, 4));
        list.add(new Animal("cu", 9999, 5));
        list.add(new Animal("middlebear", 326, 8));
        list.add(new Animal("smallbear", 326, 42));
        list.add(new Animal("bigbear", 326, 27));
        list.add(new Animal("pikachu", 35, 999));
        return list;
    }

    private static class Animal {
        private String name;
        private int intelligenceRate;
        private int musclePower;

        public Animal(String name, int intelligenceRate, int musclePower) {
            this.name = name;
            this.intelligenceRate = intelligenceRate;
            this.musclePower = musclePower;
        }

        public String getName() {
            return name;
        }

        public int getIntelligenceRate() {
            return intelligenceRate;
        }

        public int getMusclePower() {
            return musclePower;
        }
    }
}

