package ru.otus.javabasic.hw20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextFinder {
    private final File file = new File(".");
    private List<File> files = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public TextFinder() {
    }

    public void start() {
        printFiles();
        String fileName = askUserFileName();
        if (fileName == null) return;
        String phraseToFind = askPhraseToFind();
        if (phraseToFind == null) return;
        findText(fileName, phraseToFind);
    }

    public void findText(String fileName, String phraseToFind) {
        int count = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                int index = line.indexOf(phraseToFind);
                while (index != -1) {
                    count++;
                    index = line.indexOf(phraseToFind, index + phraseToFind.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Количество совпадений фразы '" + phraseToFind + "' в файле: " + count);
    }

    private void printFiles() {
        File[] listFiles = file.listFiles();
        files = Arrays.stream(listFiles).filter(File::isFile).collect(Collectors.toList());
        if (files.size() > 0) {
            System.out.printf("Список файлов в корневом проекте(%d):\n", files.size());
            for (File f : files) {
                System.out.println(f.getName());
            }
            System.out.println();
        }
    }

    private String askUserFileName() {
        System.out.println("Выберите файл для работы или :qa! для выхода");
        System.out.println();
        String response = scanner.nextLine();
        if (response.equals(":qa!") || response.strip().equals("")) {
            return null;
        }
        return response;
    }

    private String askPhraseToFind() {
        System.out.println("\nВведите текст который хотите найти в файле. :qa! для выхода\n");
        String response = scanner.nextLine();
        if (response.equals(":qa!") || response.strip().equals("")) {
            return null;
        }
        return response;
    }
}