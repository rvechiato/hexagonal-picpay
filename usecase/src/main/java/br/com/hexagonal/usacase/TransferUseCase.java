package br.com.hexagonal.usacase;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String toTaxNumber, String fromTaxNumbr, BigDecimal value, String pin);
}
