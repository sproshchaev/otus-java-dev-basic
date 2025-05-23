package ru.otus.java.basic.http.server.exceptions;

import java.time.LocalDateTime;

public class ErrorDto {
    private String code;
    private String description;
    private String datetime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public ErrorDto(String code, String description) {
        this.code = code;
        this.description = description;
        this.datetime = LocalDateTime.now().toString();
    }
}
