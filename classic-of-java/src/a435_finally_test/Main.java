package a435_finally_test;

public class Main {
    public static void main(String[] args) {
//        finally run
//        10
        System.out.println(func());
    }

    private static int func() {
        try {
            return 10;
        } catch (Exception e) {
            return 20;
        } finally {
            System.out.println("finally run");
        }
    }
}
