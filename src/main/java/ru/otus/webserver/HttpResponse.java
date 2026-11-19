package ru.otus.webserver;

import java.io.*;
import java.nio.charset.StandardCharsets;

public record HttpResponse(int statusCode, String reason, String contentType, byte[] body) {
    public static HttpResponse text(int code, String reason, String body) {
        return new HttpResponse(code, reason, "text/plain; charset=UTF-8", body.getBytes(StandardCharsets.UTF_8));
    }
    public static HttpResponse html(String body) {
        return new HttpResponse(200, "OK", "text/html; charset=UTF-8", body.getBytes(StandardCharsets.UTF_8));
    }
    public static HttpResponse json(String body) {
        return new HttpResponse(200, "OK", "application/json; charset=UTF-8", body.getBytes(StandardCharsets.UTF_8));
    }
    public static HttpResponse notFound() { return text(404, "Not Found", "Not Found"); }
    public static HttpResponse badRequest() { return text(400, "Bad Request", "Bad Request"); }

    public static HttpResponse methodNotAllowed() {
        return text(405, "Method Not Allowed", "Method Not Allowed");
    }

    public void writeTo(OutputStream out) throws IOException {
        String headers = "HTTP/1.1 " + statusCode + " " + reason + "\r\n"
                + "Content-Type: " + contentType + "\r\n"
                + "Content-Length: " + body.length + "\r\n"
                + (statusCode == 405 ? "Allow: GET\r\n" : "")
                + "Connection: close\r\n\r\n";
        out.write(headers.getBytes(StandardCharsets.US_ASCII));
        out.write(body);
        out.flush();
    }
}
