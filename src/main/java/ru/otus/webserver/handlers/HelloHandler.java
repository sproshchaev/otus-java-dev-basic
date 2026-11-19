package ru.otus.webserver.handlers;

import ru.otus.webserver.*;

public class HelloHandler implements HttpHandler {
    public HttpResponse handle(HttpRequest request) {
        return HttpResponse.text(200, "OK", "Hello from Java!");
    }
}
