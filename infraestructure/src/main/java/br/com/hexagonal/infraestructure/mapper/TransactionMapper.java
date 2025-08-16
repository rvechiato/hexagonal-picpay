package br.com.hexagonal.infraestructure.mapper;

import br.com.hexagonal.core.domain.Transaction;
import br.com.hexagonal.infraestructure.entity.TransactionEntity;

public class TransactionMapper {
    private WalletMapper walletMapper;
    private TransactionPinMapper transactionPinMapper;

    public TransactionEntity toTransactionEntity(Transaction transaction){
        return new TransactionEntity(
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity){
        return new Transaction(
                transactionEntity.getId(),
                walletMapper.toWallet(transactionEntity.getFromWallet()),
                walletMapper.toWallet(transactionEntity.getToWallet()),
                transactionEntity.getValue(),
                transactionEntity.getStatusEnum(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getUpdatedAt()
        );
    }

    public TransactionEntity concludeTransaction(Transaction transaction){
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }
}
