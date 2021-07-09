package mypackage.chapter4;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lion {
    public static void main(String[] args) {

        List<String> result = Stream.of("우테코", "짱짱", "모두들 다같이", "루터에서 열심히", "스터디 합시다", "화이팅 화이팅")
                .filter(s -> {
                    System.out.println("filtering " + s);
                    return s.length()>=4;
                })
                .map(s -> {
                    System.out.println("mapping " + s);
                    return s;
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("결과:");
        result.forEach(System.out::println);
    }
}

