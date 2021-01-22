package CountSortedVowelStrings;

import java.util.Arrays;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        if (n == 1) return 5;
        // 해당 모음으로 끝나는 수
        int[] count = new int[5];
        for (int i = 0; i < 5; i++) {
            count[i] = 1;
        }
        // [ a, e, i, o, u ]
        // 글자수
        for (int i = 2; i <= n; i++) {
            // u로 끝나는 글자는 u만 붙일 수 있으니까 더할게 없고
            // o로 끝나는 글자는 u를 붙일 수 있으니까 count[u]에 더하고
            // i로 끝나는 글자도 u를 붙일 수 있으니까 count[u]에 더하고 이런
            for (int j = 3; j >= 0; j--) {
                for (int k = j + 1; k < 5; k++) {
                    count[k] += count[j];
                }
            }
        }
        return Arrays.stream(count)
                .sum();
    }
}
