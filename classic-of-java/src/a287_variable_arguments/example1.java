package a287_variable_arguments;

public class example1 {
    static String concatenate(String delim, String... args) {
        String ret = "";
        System.out.println(ret.getClass().getName());
        System.out.println(args.getClass().getName());
        System.out.println(args.length);
        for (String s : args) {
            ret += s + delim;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(concatenate(",", "a", "b", "c"));
        System.out.println(concatenate(",", new String[]{"a", "b", "c"}));
    }
}
