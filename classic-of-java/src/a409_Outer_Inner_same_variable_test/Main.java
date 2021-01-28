package a409_Outer_Inner_same_variable_test;

public class Main {
    int var = 10;

    class Inner {
        int var = 20;
        void func() {
            int var = 30;
            System.out.println(Main.this.var);  // 10
            System.out.println(this.var);       // 20
            System.out.println(var);            // 30
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.new Inner().func();
    }
}
