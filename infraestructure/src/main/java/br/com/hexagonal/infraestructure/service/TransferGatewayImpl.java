package br.com.hexagonal.infraestructure.service;

import br.com.hexagonal.application.gateway.TransferGateway;
import br.com.hexagonal.core.domain.Transaction;
import br.com.hexagonal.infraestructure.mapper.TransactionMapper;
import br.com.hexagonal.infraestructure.mapper.WalletMapper;
import br.com.hexagonal.infraestructure.repository.TransactionEntityRepository;
import br.com.hexagonal.infraestructure.repository.WalletEntityRepository;
import jakarta.transaction.Transactional;

public class TransferGatewayImpl implements TransferGateway  {

    private WalletEntityRepository walletEntityRepository;
    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;
    private WalletMapper walletMapper;

    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
        this.walletMapper = walletMapper;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getFromWallet()));
        walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getToWallet()));

        transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));

        return null;
    }
}
