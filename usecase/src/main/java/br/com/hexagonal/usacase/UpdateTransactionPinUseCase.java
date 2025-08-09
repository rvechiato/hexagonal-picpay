package br.com.hexagonal.usacase;

import br.com.hexagonal.core.domain.TransactionPin;

public interface UpdateTransactionPinUseCase {
    TransactionPin update(TransactionPin transactionPin);
}
