package ru.otus.javabasic.hw21;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadPrintCharSequence {
    private final Object monitor = new Object();
    private char[] charMask;
    private char ch;

    public MultiThreadPrintCharSequence(char[] charMask) {
        this.charMask = charMask;
        ch = charMask[charMask.length - 1];
    }

    private void printChar(char ch) {
        try {
            int charIndex = 0;
            for (int i = 0; i < charMask.length; i++) {
                if (charMask[i] == ch) {
                    charIndex = i;
                }
            }
            int checkIndex = charIndex - 1;
            if (checkIndex == -1) {
                checkIndex = charMask.length - 1;
            }
            while (this.ch != charMask[checkIndex]) {
                monitor.wait();
            }
            System.out.print(ch);
            this.ch = ch;
            monitor.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        ExecutorService serv = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            for (char c : charMask) {
                serv.execute(() -> {
                    synchronized (monitor) {
                        printChar(c);
                    }
                });
            }
        }
        serv.shutdown();
    }
}