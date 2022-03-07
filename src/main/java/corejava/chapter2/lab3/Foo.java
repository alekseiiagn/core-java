package corejava.chapter2.lab3;

public class Foo {
    private int number1;
    private int number2;
    private int number3;
    String str = "Hello!";

    Foo() {
        number1 = 0;
        number2 = 0;
        number3 = 0;
        //хотя им и так 0 присвоится
    }

    public void getGreeting() {
        System.out.println(str);
    }

    public void getNumber1InInteger(Foo1 foo1) {
        foo1.setNumber1(number1);
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }

    public Foo setNumber1(int number1) {
        this.number1 = number1;
        return this;
    }

    public Foo setNumber2(int number2) {
        this.number2 = number2;
        return this;
    }

    public Foo setNumber3(int number3) {
        this.number3 = number3;
        return this;
    }
}


