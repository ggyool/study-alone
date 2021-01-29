package a442_re_throwing;

public class Main {
    public static void main(String[] args) {
        try {
            func();
        } catch (Exception exception) {
            System.out.println("호출한 부에서 처리할 내용");
        }
    }

    private static void func() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("메소드 내부에서 처리할 내용");
            throw e;
        }
    }
}
