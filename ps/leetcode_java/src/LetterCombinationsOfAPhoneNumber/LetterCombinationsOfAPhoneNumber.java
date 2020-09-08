package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    HashMap<Character, String> mp = new HashMap<>();

    private void solve(int i, StringBuilder sb, String digits, List<String> ans) {
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String s = mp.get(digits.charAt(i));
        for(int j=0; j<s.length(); ++j){
            sb.append(s.charAt(j));
            solve(i+1, sb, digits, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        if(!digits.equals(""))
            solve(0, sb, digits, ans);
        return ans;
    }


}
