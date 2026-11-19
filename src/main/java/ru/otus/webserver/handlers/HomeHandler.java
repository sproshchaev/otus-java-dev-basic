package ru.otus.webserver.handlers;

import ru.otus.webserver.*;

public class HomeHandler implements HttpHandler {
    public HttpResponse handle(HttpRequest request) {
        return HttpResponse.html("""
                <!doctype html>
                <html lang="ru"><head><meta charset="UTF-8"><title>Java Web Server</title></head>
                <body><h1>Привет! Это наш Java Web Server</h1>
                <p>Сервер написан на Java 17 без веб-фреймворков.</p>
                <ul><li><a href="/hello">/hello</a></li><li><a href="/api/info">/api/info</a></li></ul>
                </body></html>
                """);
    }
}
