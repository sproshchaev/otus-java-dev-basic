package ru.otus.java.basic.http.server.exceptions;

public class BadRequestException extends RuntimeException {
    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return description;
    }

    public BadRequestException(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
