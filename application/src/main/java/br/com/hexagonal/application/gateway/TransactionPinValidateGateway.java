package br.com.hexagonal.application.gateway;

import br.com.hexagonal.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {
    Boolean validate(TransactionPin transactionPin);
}
