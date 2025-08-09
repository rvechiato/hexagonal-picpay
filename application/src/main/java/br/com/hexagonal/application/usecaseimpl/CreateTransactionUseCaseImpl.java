package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.CreateTransactionGateway;
import br.com.hexagonal.core.domain.Transaction;
import br.com.hexagonal.core.domain.enuns.ErrorCodeEnum;
import br.com.hexagonal.core.exception.TransferException;
import br.com.hexagonal.usacase.CreateTransactionUseCase;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction Transaction) {
        var savedTransaction = createTransactionGateway.create(Transaction);
        if (savedTransaction != null){
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }
        return savedTransaction;
    }
}
