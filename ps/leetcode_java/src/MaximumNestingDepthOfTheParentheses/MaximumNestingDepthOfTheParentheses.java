package MaximumNestingDepthOfTheParentheses;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int depth = 0;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
                ret = Math.max(ret, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        return ret;
    }
}
