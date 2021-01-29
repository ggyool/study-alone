package a437_try_with_resources;

public class Main {
    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            resource.workException(true);
        } catch (WorkException e) {
            e.printStackTrace();
        } catch (CloseException e) {
            e.printStackTrace();
        }
    }
}

class Resource implements AutoCloseable {
    public void workException(boolean isException) throws WorkException {
        System.out.println("workException(" + isException + ") run");
        if (isException) {
            throw new WorkException("Work Exception 발생");
        }
    }
    @Override
    public void close() throws CloseException {
        System.out.println("close() run");
        throw new CloseException("Close Exception 발생");
    }
}

class WorkException extends Exception {
    public WorkException(String msg) {
        super(msg);
    }
}

class CloseException extends Exception {
    public CloseException(String msg) {
        super(msg);
    }
}