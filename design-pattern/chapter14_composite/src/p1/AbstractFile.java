package p1;

public abstract class AbstractFile {
    private final String name;
    protected int depth = 0;

    protected AbstractFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
        // 변경한 부분
        setChildDepth(depth + 1);
    }

    public abstract int getSize();

    public abstract void print();

    // 변경한 부분
    public abstract void setChildDepth(int depth);
}
