package br.com.hexagonal.infraestructure.service;

import br.com.hexagonal.application.gateway.CreateTransactionGateway;
import br.com.hexagonal.core.domain.Transaction;
import br.com.hexagonal.infraestructure.mapper.TransactionMapper;
import br.com.hexagonal.infraestructure.repository.TransactionEntityRepository;

import java.util.Optional;

public class CreateTransactionGatewayImpl  implements CreateTransactionGateway {
    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;

    @Override
    public Transaction create(Transaction transaction) {
        return Optional.of(transactionEntityRepository.save(transactionMapper.toTransactionEntity(transaction)))
                .map(transactionMapper::toTransaction)
                .orElse(null);
    }
}
