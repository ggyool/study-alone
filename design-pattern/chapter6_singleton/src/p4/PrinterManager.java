package p4;

public class PrinterManager {
    private static final int PRINTER_MAX_COUNT = 3;
    private int availablePrinterCount = PRINTER_MAX_COUNT;

    private Printer[] printers = new Printer[PRINTER_MAX_COUNT];

    private PrinterManager() {
        System.out.println("constructor run");
        for (int i = 0; i < PRINTER_MAX_COUNT; i++) {
            printers[i] = new Printer();
        }
    }

    private static class SingletonHolder {
        private static final PrinterManager instance = new PrinterManager();
    }

    public static PrinterManager getPrinterManager() {
        return SingletonHolder.instance;
    }

    private synchronized void subPrinterCount() {
        this.availablePrinterCount--;
    }

    public synchronized void addPrinterCount() {
        this.availablePrinterCount++;
    }

    // 책 정답에 있는 코드는 while loop로 printer를 얻을 수 있을 때까지 대기하였음
    // wait notify로 하는게 더 좋은 코드인 것 같아 만들어봄
    // 좋은 코드인지는 잘 모르겠음
    // Printer 객체가 print 하고 printerManager notify 함
    // 그래서 Printer.print(PrinterManager, name)이 되었음
    public synchronized Printer getPrinter() {
        if (availablePrinterCount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subPrinterCount();

        for (int i = 0; i < PRINTER_MAX_COUNT; i++) {
            Printer printer = printers[i];
            if (printer.isAvailable()) {
                printer.setAvailable(false);
                return printer;
            }
        }
        return null;
    }

    public synchronized void notifyPrinter() {
        notify();
    }
}