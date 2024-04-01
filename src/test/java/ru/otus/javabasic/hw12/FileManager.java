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
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(fileName))) {
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
        System.out.println();
        System.out.println("Введите текст который вы ходите добавить к файлу. :qa! для выхода");
        System.out.println();
        String response = scanner.nextLine();
        if (response.equals(":qa!") || response.strip().equals("")) {
            return null;
        }
        return response;
    }

    private void appendToFile(String fileName, String text) {
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(fileName))) {
            int n = in.read();
            while (n != -1) {
                sb.append((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileName))) {
            sb.append(text);
            out.write(sb.toString());
            out.flush();
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
            System.out.println("Список файлов в корневом проекте:");
            for (int i = 0; i < files.size(); i++) {
                System.out.println(i + 1 + " " + files.get(i).getName());
            }
            System.out.println();
        }
    }
}