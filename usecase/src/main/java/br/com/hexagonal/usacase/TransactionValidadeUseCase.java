package br.com.hexagonal.usacase;

import br.com.hexagonal.core.domain.Transaction;

public interface TransactionValidadeUseCase {
    Boolean isValidTransaction(Transaction transaction);
}
