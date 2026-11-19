package ru.otus.webserver;

import java.io.*;
import java.util.*;

public record HttpRequest(String method, String path, String version, Map<String, String> headers) {
    public static HttpRequest readFrom(BufferedReader reader) throws IOException {
        String requestLine = reader.readLine();
        if (requestLine == null || requestLine.isBlank()) {
            throw new BadRequestException("Empty request");
        }
        String[] parts = requestLine.split(" ", -1);
        if (parts.length != 3 || parts[0].isBlank() || !parts[1].startsWith("/")
                || !parts[2].equals("HTTP/1.1")) {
            throw new BadRequestException("Invalid request line");
        }

        Map<String, String> headers = new LinkedHashMap<>();
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            int colon = line.indexOf(':');
            if (colon <= 0) throw new BadRequestException("Invalid header");
            headers.put(line.substring(0, colon).trim().toLowerCase(Locale.ROOT),
                    line.substring(colon + 1).trim());
        }
        if (line == null) {
            throw new BadRequestException("Missing end of headers");
        }
        return new HttpRequest(parts[0], parts[1], parts[2], Map.copyOf(headers));
    }
}
