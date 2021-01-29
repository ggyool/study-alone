package a456_clone_example;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(10, 20);
        Point copy = point.clone();
        System.out.println(point);
        System.out.println(copy);
    }
}

class Point implements Cloneable {
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    protected Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
