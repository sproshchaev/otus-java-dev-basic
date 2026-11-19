package ru.otus.webserver.handlers;

import ru.otus.webserver.*;

public class ApiInfoHandler implements HttpHandler {
    public HttpResponse handle(HttpRequest request) {
        return HttpResponse.json("""
                {"name":"Java Web Server","version":"1.0.0","java":17}
                """);
    }
}
