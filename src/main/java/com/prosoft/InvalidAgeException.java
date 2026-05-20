package com.prosoft;

/**
 * Кастомное непроверяемое исключение
 */
public class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String message) {
        super(message);
    }

}
