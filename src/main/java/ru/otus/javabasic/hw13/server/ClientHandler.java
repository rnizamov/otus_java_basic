package ru.otus.javabasic.hw13.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
    private final Socket socket;
    private final Server server;
    private final DataInputStream in;
    private final DataOutputStream out;

    public ClientHandler(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                System.out.println("Подключился новый клиент");
                if (askUser()) {
                    communicate();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void communicate() throws IOException {
        while (true) {
            sendMessage("Осуществите ввод по маске: число число операнд");
            String msg = in.readUTF();
            if (msg.startsWith("exit")) {
                break;
            }
            String[] arr = msg.split(" ", 3);
            if (arr.length != 3) {
                sendMessage("Осуществите ввод по маске: число число операнд");
            }
            long operand1 = Long.parseLong(arr[0]);
            long operand2 = Long.parseLong(arr[1]);
            String operator = arr[2];
            switch (operator) {
                case "+":
                    sendMessage(String.valueOf(operand1 + operand2));
                    break;
                case "-":
                    sendMessage(String.valueOf(operand1 - operand2));
                    break;
                case "*":
                    sendMessage(String.valueOf(operand1 * operand2));
                    break;
                case "/":
                    if (operand2 == 0) {
                        sendMessage("на ноль делить нельзя!");
                        continue;
                    } else {
                        sendMessage(String.valueOf(operand1 / operand2));
                    }
                    break;
            }
        }
    }

    private boolean askUser() throws IOException {
        while (true) {
            sendMessage("Вам доступны операции: +, -, *, /");
            sendMessage("Введите y/n чтобы продолжить или завершить диалог");
            String msg = in.readUTF();
            if (msg.equals("n")) {
                break;
            }
            if (msg.equals("y")) {
                return true;
            }
        }
        return false;
    }

    public void disconnect() {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
