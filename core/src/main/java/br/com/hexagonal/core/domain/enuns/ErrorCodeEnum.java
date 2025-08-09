package br.com.hexagonal.core.domain.enuns;

public enum ErrorCodeEnum {

    TR0001 ("Shopkeeper has no transfer function available", "TR0001"),
    TR0002 ("Insuficents founds", "TR0001"),
    TR0003 ("Transfer proccess error", "TR0003"),
    TR0004 ("Transfer not Authorized", "TR0003"),
    TRP001 ("Invalid PIN", "TRP001"),
    TRP003("Error to proccess transfer", "TRP003"),
    ON0001 ("Tax Number is invalid", "ON0001"),
    ON0002("Tax number is already in use", "ON0002"),
    ON0003("Email is already in use", "ON0003"),
    ON0004("Internal server error", "ON004"),

    WA0001("Wallet not found", "WA0001"),
    NOT001("Notification error", "NOT001"),
    AUTH001("Authentication error", "AUTH001"),
    PIN001("PIN transaction block", "PIN001"),
    PIN002("PIN incorrect , %d tentativa(s) restante(s)", "PIN002"),;

    private String  message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public static String pin001GetMessage(Integer attempt) {
        return String.format(PIN002.message, attempt);
    }
}
