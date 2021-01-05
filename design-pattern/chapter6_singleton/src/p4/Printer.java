package p4;

public class Printer {
    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    public void print(PrinterManager printerManager, String name) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(name + " " + this.toString());
        setAvailable(true);
        printerManager.notifyPrinter();
        printerManager.addPrinterCount();
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
