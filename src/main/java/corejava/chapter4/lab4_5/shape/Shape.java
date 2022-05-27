package corejava.chapter4.lab4_5.shape;

import corejava.chapter4.lab1_2_3.Point;

public abstract class Shape {
    Point point;

    Shape(Point point) {
        this.point = point;
    }

    public void moveBy(int x, int y) {
        point = point.addX(x).addY(y);
    }

    public Point getCentre() {
        return point;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "point=" + point +
                '}';
    }

    @Override
    public abstract Shape clone();
}
