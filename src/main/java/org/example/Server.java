package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket socket = new ServerSocket(PORT)) {
            System.out.println("start server");
            while (true) {
                try (Socket socketClient = socket.accept();
                     PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
                ) {
                    out.println("Write your name");
                    String infoFromClient = in.readLine();
                    String clientName = infoFromClient;
                    out.println("Hello " + infoFromClient + "\n" + "Are you child? (yes/no)");
                    String info2 = in.readLine();
                    switch (info2) {
                        case "yes":
                            out.println("Welcome to the kids area, " + clientName + ". Let's play!");
                            break;
                        case "no":
                            out.println("Welcome to the adult zone, " + clientName + ". Have a good rest, or a good working day!");
                            break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
