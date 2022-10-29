package corejava.chapter6.lab23;

import corejava.chapter6.Exceptions;

import java.io.IOException;

public class Lab23 {

    public static void main(String[] args) {
        Exceptions.<RuntimeException>throwAs(new IOException("Hello world"));

        //Потому что могут быть переданы совершенно разные типы исключений,
        //не все их них можно закастить к Runtime
    }
}
