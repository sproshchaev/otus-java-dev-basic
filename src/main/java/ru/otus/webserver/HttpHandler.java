package ru.otus.webserver;
@FunctionalInterface
public interface HttpHandler {
    HttpResponse handle(HttpRequest request);
}
