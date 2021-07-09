package modernjavainaction.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MemberManager {
    public static void main(String[] args) {
        final Names names = new Names();
        final List<String> inputNames = Arrays.asList("mediumBear", "kason", "bobi", "bobi", "bobi");


        final Predicate<String> kasonFilter = s -> "kason".equals(s);

        names.printAll(); // mediumBear
    }
}

class Names {
    final List<String> names = new ArrayList<>();

    public void addAll(final List<String> values) {
        names.addAll(values);
    }

    public void printAll() {
        System.out.println("신입 교육생");
        names.forEach(System.out::println);
    }

    public void addSatisfiedNames(final List<String> inputNames, final Predicate<String> predicate) {
        for (final String inputName : inputNames) {
            if (predicate.test(inputName)) {
                names.add(inputName);
            }
        }
    }
}
