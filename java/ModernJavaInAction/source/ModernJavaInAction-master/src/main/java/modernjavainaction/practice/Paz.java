package modernjavainaction.practice;

import java.util.function.Function;
import java.util.function.Predicate;
// 파즈
public class Paz {
    static class Fruit {
        public String name;

        public Fruit(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        final Function<String, Fruit> createFruitFunction = Fruit::new;
        Fruit orange = createFruitFunction.apply("orange");
        printNameIfOrange(orange, (Fruit f) -> f.getName().equals("orange"));
    }

    private static void printNameIfOrange(final Fruit fruit, final Predicate<Fruit> orangeFilter) {
        if (orangeFilter.test(fruit)) {
            System.out.println(fruit.getName());
        }
    }
}
