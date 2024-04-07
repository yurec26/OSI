package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socketClient = new Socket("netology.homework", Server.PORT)) {
            PrintWriter printWriter = new PrintWriter(socketClient.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            //
            Scanner sc = new Scanner(System.in);
            //
            System.out.println(bufferedReader.readLine());
            printWriter.println(sc.nextLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            printWriter.println(sc.nextLine());
            System.out.println(bufferedReader.readLine());
            //
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
