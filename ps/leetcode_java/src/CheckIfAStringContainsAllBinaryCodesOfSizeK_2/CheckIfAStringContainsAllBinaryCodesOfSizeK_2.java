package CheckIfAStringContainsAllBinaryCodesOfSizeK_2;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK_2 {
    public boolean hasAllCodes(String s, int k) {
        int total = 1 << k; // 1000
        int oneBit = total - 1; // 111
        boolean[] visited = new boolean[total];

        // 한 칸 왼쪽으로 밀고 0 or 1 을 더한다.
        int count = 0;
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            val = (val << 1) & oneBit;
            val += s.charAt(i) - '0';
            if ( (i >= k-1) && !visited[val]) {
                visited[val] = true;
                count++;
            }
        }
        return count == total;
    }
}
