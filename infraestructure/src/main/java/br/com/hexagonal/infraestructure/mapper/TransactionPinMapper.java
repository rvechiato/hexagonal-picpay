package br.com.hexagonal.infraestructure.mapper;

import br.com.hexagonal.core.domain.TransactionPin;
import br.com.hexagonal.infraestructure.entity.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {
    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin){
        return new TransactionPinEntity(
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocked(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdatedAt()
        );
    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionPinEntity){
        return new TransactionPin(
                transactionPinEntity.getId(),
                transactionPinEntity.getPin(),
                transactionPinEntity.getAttempts(),
                transactionPinEntity.getIsBlocked(),
                transactionPinEntity.getCreatedAt(),
                transactionPinEntity.getUpdatedAt()
        );
    }
}
