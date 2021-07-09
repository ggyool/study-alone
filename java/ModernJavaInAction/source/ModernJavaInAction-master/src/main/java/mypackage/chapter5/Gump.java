package mypackage.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gump {
    public static void main(String[] args) {
        List<String> symbols = Arrays.asList("스페이드", "하트", "다이아몬드", "클로버");
        List<String> numbers = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");


        final List<String> cards = IntStream.range(0, symbols.size() * numbers.size())
                .mapToObj(i -> symbols.get(i % symbols.size()) + numbers.get(i % numbers.size()))
                .collect(Collectors.toList());
    }
}
