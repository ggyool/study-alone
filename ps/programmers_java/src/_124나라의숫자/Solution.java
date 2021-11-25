package _124나라의숫자;

public class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int d = n % 3;
            n /= 3;
            if (d == 0) {
                sb.append('4');
                n -= 1;
            } else if (d == 1) {
                sb.append('1');
            } else {
                sb.append('2');
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(13));
    }
}
