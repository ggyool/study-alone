package a436_try_finally_both_exception;

public class Main {
    public static void main(String[] args) {
        /*
        java.lang.RuntimeException
        at a436_try_finally_both_exception.Main.func(Main.java:21)
        at a436_try_finally_both_exception.Main.main(Main.java:7)
         */
        try {
            func();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void func() throws Exception {
        try {
            System.out.println(10 / 0);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            throw new RuntimeException();
        }
    }
}

