package mypackage.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gump {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("손너잘", "중간곰", "찰리", "웨지");
        Stream<String> stream = names.stream();
        List<Integer> nameLengths = stream.map(map -> map.length())
                .collect(Collectors.toList());
        System.out.println("nameLengths = " + nameLengths);


        List<Integer> doubleNameLengths = names.stream()
                .map(map -> map.length() * 2)
                .collect(Collectors.toList());
        System.out.println("doubleNameLengths = " + doubleNameLengths);
    }
}
