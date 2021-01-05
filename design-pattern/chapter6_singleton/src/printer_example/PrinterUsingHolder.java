package printer_example;

public class PrinterUsingHolder {
    private int count = 0;

    private PrinterUsingHolder() {
        System.out.println("constructor run");
    }

    private static class SingletonHolder {
        private static final PrinterUsingHolder printer = new PrinterUsingHolder();
    }

    public static PrinterUsingHolder getPrinter() {
        return SingletonHolder.printer;
    }

    public synchronized void print(String str) {
        count++;
        System.out.println(str + " " + count);
    }
}
