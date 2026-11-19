package ru.otus.webserver;

import java.io.IOException;
import ru.otus.webserver.handlers.ApiInfoHandler;
import ru.otus.webserver.handlers.HelloHandler;
import ru.otus.webserver.handlers.HomeHandler;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 8080;
        Router router = new Router()
                .get("/", new HomeHandler())
                .get("/hello", new HelloHandler())
                .get("/api/info", new ApiInfoHandler());
        new HttpServer(port, router).start();
    }
}
