package ru.otus.javabasic.hw12;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileManager {
    private final File file = new File(".");
    private List<File> files = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.printFiles();
    }
    public void start() {
        printFiles();

    }

    private void askUser() {
        System.out.println("Выберите файл для работы по номеру файла или :q для выхода");
    }

    private void printFiles() {
        File[] listFiles = file.listFiles();
        files = Arrays.stream(listFiles).filter(File::isFile).collect(Collectors.toList());
        if (files.size() > 0) {
            System.out.println("Список файлов в корневом проекте:");
            for (int i = 0; i < files.size(); i++) {
                System.out.println(i + 1 + " " + files.get(i).getName());
            }
        }
    }
}
