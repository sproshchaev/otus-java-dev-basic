package com.prosoft.demo.exception;

/**
 * Собственное исключение для демонстрации создания исключений
 */
public class TransformException extends RuntimeException {
    private String format;

    public String getFormat() {
        return format;
    }

    public TransformException(String message, String format) {
        super("Некорректный формат преобразования: " + format);
        this.format = format;
    }
}