package ru.otus.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RawHttpDemo {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket()) {
            server.bind(new InetSocketAddress("127.0.0.1", 8080));
            System.out.println("HTTP server: http://127.0.0.1:8080/");
            while (true) {
                try (Socket client = server.accept()) {
                    respond(client);
                } catch (IOException e) {
                    System.err.println("Client I/O error: " + e.getMessage());
                }
            }
        }
    }

    private static void respond(Socket client) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(client.getInputStream(), StandardCharsets.US_ASCII));
        String line = reader.readLine();
        if (line == null) {
            return;
        }
        while (line != null && !line.isEmpty()) {
            System.out.println(line);
            line = reader.readLine();
        }

        byte[] body = "Hello from Java!".getBytes(StandardCharsets.UTF_8);
        String headers = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/plain; charset=UTF-8\r\n"
                + "Content-Length: " + body.length + "\r\n"
                + "Connection: close\r\n\r\n";
        OutputStream out = client.getOutputStream();
        out.write(headers.getBytes(StandardCharsets.US_ASCII));
        out.write(body);
        out.flush();
    }
}
