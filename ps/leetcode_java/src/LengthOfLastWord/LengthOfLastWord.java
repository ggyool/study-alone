package LengthOfLastWord;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] srr = s.split(" ");
        return srr.length==0 ? 0 : srr[srr.length-1].length();
    }
}
