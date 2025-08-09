package br.com.hexagonal.application.gateway;

import br.com.hexagonal.core.domain.Transaction;

public interface CreateTransactionGateway {
    Transaction create(Transaction transaction);
}
