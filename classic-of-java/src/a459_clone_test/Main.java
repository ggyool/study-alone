package a459_clone_test;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(1, 1));
        list.add(new Point(2, 2));

//        ArrayList copy = (ArrayList) list.clone();
        ArrayList copy = new ArrayList(list);

        list.get(0).setX(10);
        System.out.println(list);
        System.out.println(copy);
    }
}

class Point implements Cloneable {
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
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