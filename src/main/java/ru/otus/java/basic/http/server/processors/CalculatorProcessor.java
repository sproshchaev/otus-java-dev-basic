package ru.otus.java.basic.http.server.processors;

import ru.otus.java.basic.http.server.HttpRequest;
import ru.otus.java.basic.http.server.exceptions.BadRequestException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CalculatorProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        if (!request.containsParameter("a")) {
            throw new BadRequestException("INCORRECT_REQUEST_DATA", "Отсутствует параметр запроса 'a'");
        }
        if (!request.containsParameter("b")) {
            throw new BadRequestException("INCORRECT_REQUEST_DATA", "Отсутствует параметр запроса 'b'");
        }

        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));

        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>" + a + " + " + b + " = " + (a + b) + "</h1></body></html>";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
