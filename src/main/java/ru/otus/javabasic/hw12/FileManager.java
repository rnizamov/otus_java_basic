package ru.otus.javabasic.hw12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Nizamov Rinat
 * @version 1.0
 * Main class for the application FileManager.
 */
public class FileManager {
    /**
     * This field indicating the root of the project.
     */
    private final File file = new File(".");

    /**
     * List of text files located in the project root.
     */
    private List<File> files = new ArrayList<>();

    /**
     * Object for dialogue with the user.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * This method start point of the application.
     */
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

    /**
     * This method prints the text content of the file and does not return the value.
     *
     * @param fileName String value, file name of the file to be printed to the console.
     */
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

    /**
     * A method for dialogue with the user asking to enter text to be added to a file or to exit.
     *
     * @return String value, text content or null.
     */
    private String askUserToWorkWithFile() {
        System.out.println("\nВведите текст который вы ходите добавить к файлу. :qa! для выхода\n");
        String response = scanner.nextLine();
        if (response.equals(":qa!") || response.strip().equals("")) {
            return null;
        }
        return response;
    }

    /**
     * This method is for appending text to a file on a new line.
     *
     * @param fileName String file name text will be written.
     * @param text     text content to be written to the file.
     */
    private void appendToFile(String fileName, String text) {
        text = "\n" + text;
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName, true))) {
            byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * A method for dialogue with the user offering to select a file to work on or exit.
     *
     * @return String value, file name or null.
     */
    private String askUserFileName() {
        System.out.println("Выберите файл для работы или :qa! для выхода");
        System.out.println();
        String response = scanner.nextLine();
        if (response.equals(":qa!") || response.strip().equals("")) {
            return null;
        }
        return response;
    }

    /**
     * The method prints a list of text files in the project root folder to the console and does not return the value.
     */
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