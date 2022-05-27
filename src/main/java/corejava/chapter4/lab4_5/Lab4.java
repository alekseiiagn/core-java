package corejava.chapter4.lab4_5;

import corejava.chapter4.lab1_2_3.Point;
import corejava.chapter4.lab4_5.shape.Circle;
import corejava.chapter4.lab4_5.shape.Line;
import corejava.chapter4.lab4_5.shape.Rectangle;

public class Lab4 {

    public static void main(String[] args) {

        Line line = new Line(new Point(0, 0), new Point(3, 6));
        Rectangle rectangle = new Rectangle(new Point(0, 10), 20, 10);
        Circle circle = new Circle(new Point(0, 0), 20);

        System.out.println(line);
        System.out.println(rectangle);
        System.out.println(circle);

        Line lineCopy = line.clone();
        Rectangle rectangleCopy = rectangle.clone();
        Circle circleCopy = circle.clone();

        System.out.println(lineCopy);
        System.out.println(rectangleCopy);
        System.out.println(circleCopy);
    }
}
