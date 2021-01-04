package printer_example;

public class Printer {
    private static Printer printer = null;
    private int count = 0;

    private Printer() {
    }

    public synchronized static Printer getPrinter() {
        if (printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public synchronized void print(String str) {
        count++;
        System.out.println(str + " " + count);
    }
}
