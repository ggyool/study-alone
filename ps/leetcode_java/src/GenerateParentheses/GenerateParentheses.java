package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private void solve(int open, int close, int n, StringBuilder sb, List<String> ans){
        if(open+close == 2*n) {
            ans.add(sb.toString());
            return;
        }
        if(open<n) {
            sb.append('(');
            solve(open+1, close, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open>close){
            sb.append(')');
            solve(open, close+1, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0,0,n, sb, ans);
        return ans;
    }
}
