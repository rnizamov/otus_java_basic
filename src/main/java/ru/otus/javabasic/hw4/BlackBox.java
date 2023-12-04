package ru.otus.javabasic.hw4;

public class BlackBox {
    private String color;
    private final int width;
    private final int height;
    private boolean isOpen;
    private String obj;

    public BlackBox(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isHasObject() {
        return !(obj == null);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void open() {
        System.out.println("коробка открыта");
        isOpen = true;
    }

    public void close() {
        System.out.println("коробка закрыта");
        isOpen = false;
    }

    public void printInfo() {
        System.out.println("color = " + color);
        System.out.println("width = " + width);
        System.out.println("height = " + height);
        System.out.println("isOpen = " + isOpen);
        System.out.println("hasObject = " + isHasObject());
    }

    public void add(String obj) {
        if (isHasObject()) {
            System.out.println("Коробка не пустая, нужно выбросить предмет");
            return;
        }
        if (!isOpen) {
            System.out.println("Коробка закрыта! Откройте коробку");
            return;
        }
        this.obj = obj;
        System.out.println("Предмет добавлен: " + obj);
    }

    public void clear() {
        if(!isHasObject()) {
            System.out.println("Коробка пустая!");
            return;
        }
        if (!isOpen) {
            System.out.println("Коробка закрыта! Откройте коробку");
            return;
        }
        String obj = this.obj;
        this.obj = null;
        System.out.println("Предмет удален: " + obj);
    }
}