package corejava.chapter3.additional.Theory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class TheoryTask {
    public static Random random = new Random();
    public static List<MyNumber> myNumberList = new ArrayList<>() {{
        add(new MyNumber(random.nextInt(25)));
        add(new MyNumber(random.nextInt(25)));
        add(new MyNumber(random.nextInt(25)));
        add(new MyNumber(random.nextInt(25)));
        add(new MyNumber(random.nextInt(25)));
        add(new MyNumber(random.nextInt(25)));
        add(new MyNumber(random.nextInt(25)));
        add(new MyNumber(random.nextInt(25)));
        add(new MyNumber(random.nextInt(25)));
        add(new MyNumber(random.nextInt(25)));
    }};

    public static List<MyNumber> foo(Predicate<MyNumber> filter) {
        return myNumberList.stream()
                .filter(filter)
                .toList();
    }

    public static void main(String[] args) {

        System.out.println("Class::StaticMethod");
        System.out.println(foo(MyNumber::moreThenTen));
        System.out.println(foo(o -> MyNumber.moreThenTen(o)));

        System.out.println("Class::InstanceMethod");
        System.out.println(foo(MyNumber::moreThenFive));
        System.out.println(foo(o -> o.moreThenFive()));

        System.out.println("Object::InstanceMethod");
        MyNumber myNumber = new MyNumber(10);
        System.out.println(foo(myNumber::moreThen));
        System.out.println(foo(o -> myNumber.moreThen(o)));

        //3 различия лямбды и анонимного класса
        //для анонимного класса не обязательно переопределять все методы, и не всегда нужно, в свою очередь интерефейс создан для того, чтобы писать свою реализацию к методам
        //интерфейс не содержит состояния
        //интерфейс implement, а класс extend

    }
}
