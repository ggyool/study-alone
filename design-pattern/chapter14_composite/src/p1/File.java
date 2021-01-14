package p1;

public class File extends AbstractFile {
    private final int size;

    protected File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void print() {
        int depth = getDepth();
        String name = getName();
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println("[File] " + name + ", Size: " + size);
    }

    @Override
    public void setChildDepth(int depth) {
        // 파일은 아무 것도 안함
    }
}
