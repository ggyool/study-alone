package p1;

import java.util.ArrayList;
import java.util.List;

public class Directory extends AbstractFile {
    private final List<AbstractFile> files = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void addEntry(AbstractFile entry) {
        entry.setDepth(getDepth() + 1);
        files.add(entry);
    }

    public void removeEntry(AbstractFile entry) {
        files.remove(entry);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        totalSize += files.stream()
                .mapToInt(AbstractFile::getSize)
                .sum();
        return totalSize;
    }

    @Override
    public void print() {
        int depth = getDepth();
        String name = getName();
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println("[Directory] " + name + ", Size: " + getSize());

        files.stream()
                .forEach(AbstractFile::print);
    }

    @Override
    public void setChildDepth(int depth) {
        files.stream()
                .forEach(entry -> entry.setDepth(depth));
    }
}
