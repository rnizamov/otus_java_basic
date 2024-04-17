package ru.otus.javabasic.hw21;

public class App {
    public static void main(String[] args) {
        MultiThreadPrintCharSequence ps = new MultiThreadPrintCharSequence(new char[]{'A', 'B', 'C'});
        ps.start();
    }
}
