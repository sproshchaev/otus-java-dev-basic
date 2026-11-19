package ru.otus.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private final int port;
    private final Router router;

    public HttpServer(int port, Router router) {
        this.port = port;
        this.router = router;
    }

    public void start() throws IOException {
        ExecutorService workers = Executors.newFixedThreadPool(10);
        try (ServerSocket server = new ServerSocket()) {
            server.bind(new InetSocketAddress("127.0.0.1", port));
            System.out.println("HTTP server: http://127.0.0.1:" + port + "/");
            while (true) {
                Socket client = server.accept();
                workers.execute(() -> handleClient(client));
            }
        } finally {
            workers.shutdown();
        }
    }

    private void handleClient(Socket client) {
        try (client) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(client.getInputStream(), StandardCharsets.US_ASCII));
            HttpResponse response;
            try {
                response = router.handle(HttpRequest.readFrom(reader));
            } catch (BadRequestException e) {
                response = HttpResponse.badRequest();
            }
            response.writeTo(client.getOutputStream());
        } catch (IOException e) {
            System.err.println("Client I/O error: " + e.getMessage());
        }
    }
}
