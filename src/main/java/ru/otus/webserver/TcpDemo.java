package ru.otus.webserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpDemo {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket()) {
            server.bind(new InetSocketAddress("127.0.0.1", 8080));
            System.out.println("TCP server: 127.0.0.1:8080");
            while (true) {
                try (Socket client = server.accept()) {
                    System.out.println("Client connected");
                }
            }
        }
    }
}
