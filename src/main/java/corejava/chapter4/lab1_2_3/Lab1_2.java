package corejava.chapter4.lab1_2_3;

public class Lab1_2 {
    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Point p3 = p1;
        Point p4 = null;
        Point p5 = new Point(1, 2);

        LabeledPoint lp1 = new LabeledPoint("hello world", 1, 1);
        LabeledPoint lp2 = new LabeledPoint("hello world", 1, 2);
        LabeledPoint lp3 = lp1;
        LabeledPoint lp4 = null;
        LabeledPoint lp5 = new LabeledPoint("hello", 1, 1);
        LabeledPoint lp6 = new LabeledPoint("hello world", 1, 1);

        System.out.println(p1 + "==" + p2 + " : " + p1.equals(p2) +'\n'+
                p1 + "==" + p3 + " : " + p1.equals(p3) + '\n'+
                p1 + "==" + p1 + " : " + p1.equals(p1) +'\n'+
                p1 + "==" + p4 + " : " + p1.equals(p4) +'\n'+
                p1 + "==" + lp2 + " : " + p1.equals(lp2) +'\n'+
                p1 + "==" + lp6 + " : " + p1.equals(lp6) +'\n'+
                p1 + "==" + p5 + " : " + p1.equals(p5)
        );

        System.out.println(lp1 + "==" + lp2 + " : " + lp1.equals(lp2) +'\n'+
                lp1 + "==" + lp3 + " : " + lp1.equals(lp3) + '\n'+
                lp1 + "==" + lp1 + " : " + lp1.equals(lp1) +'\n'+
                lp1 + "==" + lp4 + " : " + lp1.equals(lp4) +'\n'+
                lp1 + "==" + p2 + " : " + lp1.equals(p2) +'\n'+
                lp1 + "==" + p5 + " : " + lp1.equals(p5) +'\n'+
                lp1 + "==" + lp6 + " : " + lp1.equals(lp6) +'\n'+
                lp1 + "==" + lp5 + " : " + lp1.equals(lp5)
        );

    }
}
