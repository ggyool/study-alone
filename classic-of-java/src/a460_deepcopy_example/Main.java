package a460_deepcopy_example;

public class Main {
    public static void main(String[] args){
        Circle circle = new Circle(new Point(1,1), 10.0);
        Circle shallowCopy = circle.shallowCopy();
        Circle deepCopy = circle.deepCopy();
        System.out.println(circle);
        System.out.println(shallowCopy);
        System.out.println(deepCopy);
    }
}

class Point {
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Circle implements Cloneable {
    Point p;
    double r;

    public Circle(Point p, double r) {
        this.p = p;
        this.r = r;
    }

    public Circle shallowCopy() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Circle deepCopy() {
        Circle copy = shallowCopy();
        copy.p = new Point(p.x, p.y);
        return copy;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "p=" + p +
                ", r=" + r +
                '}';
    }
}

