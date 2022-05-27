package corejava.chapter4.lab4_5.shape;

import corejava.chapter4.lab1_2_3.Point;

public class Circle extends Shape{

    double radius;

    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", centre=" + point +
                '}';
    }

    @Override
    public Circle clone() {
        return new Circle(point, radius);
    }
}
