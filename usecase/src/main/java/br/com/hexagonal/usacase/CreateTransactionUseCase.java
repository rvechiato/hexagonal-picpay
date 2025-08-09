package br.com.hexagonal.usacase;

import br.com.hexagonal.core.domain.Transaction;

public interface CreateTransactionUseCase {
    Transaction create(Transaction Transaction);
}
