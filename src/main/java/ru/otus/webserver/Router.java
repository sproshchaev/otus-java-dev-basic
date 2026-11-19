package ru.otus.webserver;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private final Map<String, HttpHandler> getHandlers = new HashMap<>();
    public Router get(String path, HttpHandler handler) {
        getHandlers.put(path, handler);
        return this;
    }
    public HttpResponse handle(HttpRequest request) {
        if (!"GET".equals(request.method())) {
            return HttpResponse.methodNotAllowed();
        }
        HttpHandler handler = getHandlers.get(request.path());
        return handler == null ? HttpResponse.notFound() : handler.handle(request);
    }
}
