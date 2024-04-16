package ru.otus.javabasic.hw21;

public class App {
    public static void main(String[] args) {
        MultiThreadPrintCharSequens ps = new MultiThreadPrintCharSequens(new char[]{'A', 'B', 'C'});
        ps.start();
    }
}
