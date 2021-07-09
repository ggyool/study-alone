package mypackage.chapter4.distinctsoted;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ObjDistinctSortedTest {
    public static void main(String[] args) {
        final List<Animal> animals = generateAnimals(10_000_000);

        final long start = System.nanoTime();

        final List<Animal> collect = animals.stream()
                .distinct()
                .sorted(Comparator.comparing(Animal::getAge).thenComparing(Animal::getName))
                .collect(Collectors.toList());

        System.out.println(System.nanoTime() - start);

    }

    private static List<Animal> generateAnimals(final int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> new Animal())
                .collect(Collectors.toList());
    }
}

class Animal {
    private final static Random RANDOM = new Random();
    private final int age;
    private final String name;

    public Animal() {
        this.age = RANDOM.nextInt(50_000);
        this.name = NameGenerator.generateRandomName(1);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Animal animal = (Animal) o;
        return getAge() == animal.getAge() && Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }
}

class NameGenerator {
    private static Random RANDOM = new Random();

    public static String generateRandomName(final int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append((char) (RANDOM.nextInt(26) + 'a'));
        }
        return sb.toString();
    }
}
