package br.com.hexagonal.core.exception;

public class TransferException extends RuntimeException {
    private String code;

    public TransferException(String message, String code) {
        super(message);
        this.code = code;
    }
}
