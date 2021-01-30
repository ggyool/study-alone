package a479_stringbuffer_example;

public class Main {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("123");
        String s = sb.append("456").append(789).toString();
        System.out.println(s); // 123456678

        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb1 == sb2); // false
        System.out.println(sb1.equals(sb2)); // false
        System.out.println(sb1.toString().equals(sb2.toString())); // true
    }
}
