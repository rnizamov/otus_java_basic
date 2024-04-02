package ru.otus.javabasic.hw12;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileManager {
    private final File file = new File(".");
    private List<File> files = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        printFiles();
        String fileName = askUserFileName();
        if (fileName == null) return;
        printFile(fileName);
        String askUser = askUserToWorkWithFile();
        if (askUser == null) return;
        appendToFile(fileName, askUser);
        printFile(fileName);
    }

    private void printFile(String fileName) {
        System.out.println("Содержание файла:");
        System.out.println();
        try (InputStreamReader in = new InputStreamReader(new BufferedInputStream(new FileInputStream(fileName)))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    private String askUserToWorkWithFile() {
        System.out.println("\nВведите текст который вы ходите добавить к файлу. :qa! для выхода\n");
        String response = scanner.nextLine();
        if (response.equals(":qa!") || response.strip().equals("")) {
            return null;
        }
        return response;
    }

    private void appendToFile(String fileName, String text) {
        text = "\n" + text;
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName, true))) {
            byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
}