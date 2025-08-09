package br.com.hexagonal.usacase;

import br.com.hexagonal.core.domain.TransactionPin;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin);
}
