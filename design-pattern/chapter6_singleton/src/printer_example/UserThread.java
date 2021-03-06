package printer_example;

public class UserThread extends Thread {
    public UserThread(String name) {
        super(name);
    }

    public void run() {
//        Printer printer = Printer.getPrinter();
//        printer.print(Thread.currentThread().getName() + " " + printer.toString());

        PrinterUsingHolder printer = PrinterUsingHolder.getPrinter();
        printer.print(Thread.currentThread().getName() + " " + printer.toString());
    }
}
