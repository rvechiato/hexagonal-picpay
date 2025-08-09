package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.TransactionPinValidateGateway;
import br.com.hexagonal.core.domain.TransactionPin;
import br.com.hexagonal.core.domain.enuns.ErrorCodeEnum;
import br.com.hexagonal.core.exception.PinException;
import br.com.hexagonal.usacase.TransactionPinValidateUseCase;
import br.com.hexagonal.usacase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private TransactionPinValidateGateway transactionPinValidateGateway;
    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    @Override
    public Boolean validate(TransactionPin transactionPin) {

        if(transactionPin.getBlocked()){
            throw new PinException(ErrorCodeEnum.PIN001.getMessage(), ErrorCodeEnum.PIN001.getCode());
        }

        if(!transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.setAttempt();
           var transactionPinUpdated = updateTransactionPinUseCase.update(transactionPin);
           throw new PinException(ErrorCodeEnum.pin001GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.PIN002.getCode());
        }

        if(transactionPin.getAttempt() < 3) {
            transactionPin.resetAttempt();
        }

        return true;
    }
}
