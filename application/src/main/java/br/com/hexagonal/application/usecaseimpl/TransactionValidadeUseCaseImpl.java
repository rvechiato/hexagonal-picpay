package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.TransactionValidadeGateway;
import br.com.hexagonal.core.domain.Transaction;
import br.com.hexagonal.core.domain.enuns.ErrorCodeEnum;

import br.com.hexagonal.core.exception.TransferException;
import br.com.hexagonal.usacase.TransactionValidadeUseCase;

public class TransactionValidadeUseCaseImpl implements TransactionValidadeUseCase {

    private TransactionValidadeGateway transactionValidadeGateway;

    @Override
    public Boolean isValidTransaction(Transaction transaction) {

        if(!transactionValidadeGateway.validade(transaction)){
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
