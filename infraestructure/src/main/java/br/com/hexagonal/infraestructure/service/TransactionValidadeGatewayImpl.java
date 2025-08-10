package br.com.hexagonal.infraestructure.service;

import br.com.hexagonal.application.gateway.TransactionValidadeGateway;
import br.com.hexagonal.core.domain.Transaction;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionValidadeGatewayImpl implements TransactionValidadeGateway {

    private ApiValidateService apiValidateService;

    public TransactionValidadeGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validade(Transaction transaction) {
        return Optional.of(apiValidateService.validate()).orElse(false);
    }
}
