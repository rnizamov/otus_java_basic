package ru.otus.javabasic.hw13.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        try (
                Socket socket = new Socket("localhost", 8085);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                SimpleClient client = new SimpleClient(in, out);
        ) {
            client.read();
            while (true) {
                String msg = scanner.nextLine();
                client.send(msg);
                if (msg.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
