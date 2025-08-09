package br.com.hexagonal.core.exception;

public class NotificationException extends RuntimeException {
    private String code;

    public NotificationException(String message, String code) {
        super(message);
        this.code = code;
    }
}
