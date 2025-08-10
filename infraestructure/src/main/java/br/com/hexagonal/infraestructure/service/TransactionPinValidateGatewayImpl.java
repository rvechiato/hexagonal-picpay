package br.com.hexagonal.infraestructure.service;

import br.com.hexagonal.application.gateway.TransactionPinValidateGateway;
import br.com.hexagonal.core.domain.TransactionPin;
import br.com.hexagonal.infraestructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    private TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public boolean validate(TransactionPin transactionPin) {
        return transactionPinEntityRepository. findById(transactionPin.getId())
                .map(saved-> saved.getPin().equals(transactionPin.getPin()))
                .orElse(false);
    }
}
