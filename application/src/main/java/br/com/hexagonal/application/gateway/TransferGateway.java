package br.com.hexagonal.application.gateway;

import br.com.hexagonal.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
