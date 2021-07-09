package modernjavainaction.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

/*
평화로운 우테코 동물원에는 갈색곰 중간곰, 기린 파즈, 사자 라이언이 지내고 있습니다.
각 동물은 동일한 날짜에 동물원에 들어왔는데, 어느덧 머무른 지 1달이 되었습니다.
동물들은 동물원에서 매일매일 스트레스를 받는데, 동물마다 스트레스 받는 정도가 다릅니다.
다들 아시다시피 동물은 스트레스에 매우 취약한데요.
그래서 동물원에서는 매달 스트레스를 가장 많이 받은 동물을 잠시 야생으로 보냅니다.
새로운 달을 맞아 이번에도 야생에서 한 달 간 머무를 동물을 선택하게 됐습니다.
그런데 이런! 사육사가 지난 달에 너무 바빠서 어떤 동물이 가장 스트레스가 많은지 확인하지 못했는데요.
사육사는 여러분의 힘을 빌려 이 문제를 해결하고자 합니다!
사육사를 돕기 위해 @@@ 이곳의 코드를 작성해주세요!
 */
public class Dani {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("파즈", "중간곰", "라이언");
        List<Animal> animals = names.stream()
                .map(Animal::new)
                .collect(Collectors.toList());

        List<Integer> stress = animals.stream()
                .map(Animal::stress)
                .collect(Collectors.toList());


        Map<String, Integer> animalsWithStress = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            animalsWithStress.put(names.get(i), stress.get(i));
        }
        List<Map.Entry<String, Integer>> animalsWithStressGroup = new ArrayList<>(animalsWithStress.entrySet());
        animalsWithStressGroup.sort(Map.Entry.comparingByValue());
        Collections.reverse(animalsWithStressGroup);
        System.out.println("이번 달에 야생에서 머무를 수 있는 동물은!! " + animalsWithStressGroup.get(0).getKey());
    }
}


class Animal {
    private final String name;
    private final int stress;
    private final IntFunction<Integer> giraffe = n -> n * 7304 / 3;
    private final IntUnaryOperator bear = n -> n * 4800 + 3;
    private final IntUnaryOperator lion = n -> n * 5302 / 2;

    public Animal(String name) {
        this.name = name;
        this.stress = 30;
    }
    public int stress() {
        if (name.equals("파즈")) {
            return this.giraffe.apply(stress);
        }
        if (name.equals("중간곰")) {
            return this.bear.applyAsInt(stress);
        }
        return this.lion.applyAsInt(stress);
    }
}

