package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.TransferGateway;
import br.com.hexagonal.core.domain.Transaction;
import br.com.hexagonal.core.domain.Wallet;
import br.com.hexagonal.core.domain.enuns.ErrorCodeEnum;
import br.com.hexagonal.core.exception.InternalServerErrorException;
import br.com.hexagonal.core.exception.NotificationException;
import br.com.hexagonal.core.exception.PinException;
import br.com.hexagonal.core.exception.TransferException;
import br.com.hexagonal.usacase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private FindWalletByTaxNumberUseCase findUserByTaxNumberUseCase;
    private TransactionValidadeUseCase transactionValidadeUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferGateway transferGateway;
    private UserNotificationUseCase  userNotificationUseCase;
    private TransactionPinValidateUseCase transactionPinValidateUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findUserByTaxNumberUseCase,
                               TransactionValidadeUseCase transactionValidadeUseCase,
                               CreateTransactionUseCase createTransactionUseCase,
                               TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.findUserByTaxNumberUseCase = findUserByTaxNumberUseCase;
        this.transactionValidadeUseCase = transactionValidadeUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }

    @Override
    public Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin) {
        Wallet from = findUserByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findUserByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

       transactionPinValidateUseCase.validate(from.getTransactionPin());

        if(from == null || to == null){
            throw new InternalServerErrorException(ErrorCodeEnum.TRP001.getMessage(), ErrorCodeEnum.TRP001.getCode());
        }

        from.transfer(value);
        to.receivedBalancer(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));
        transactionValidadeUseCase.isValidTransaction(transaction);

        if(!transferGateway.transfer(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TRP003.getMessage(),ErrorCodeEnum.TRP003.getCode());
        }

        if(!userNotificationUseCase.notificate(transaction, to.getUser().getEmail()))  {
            throw new NotificationException(ErrorCodeEnum.NOT001.getMessage(), ErrorCodeEnum.NOT001.getCode());
        }

        return true;
    }
}
