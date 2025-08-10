package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.CreateUserGateway;
import br.com.hexagonal.core.domain.TransactionPin;
import br.com.hexagonal.core.domain.User;
import br.com.hexagonal.core.domain.Wallet;
import br.com.hexagonal.core.domain.enuns.ErrorCodeEnum;
import br.com.hexagonal.core.exception.InternalServerErrorException;
import br.com.hexagonal.core.exception.TaxNumberException;
import br.com.hexagonal.core.exception.TransactionPinException;
import br.com.hexagonal.usacase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final TaxNumerAvailableUseCase taxNumerAvailableUseCase;
    private final EmailAvailableUseCase emailAvailableUseCase;
    private final CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(TaxNumerAvailableUseCase taxNumerAvailableUseCase,
                                 EmailAvailableUseCase emailAvailableUseCase,
                                 CreateUserGateway createUserGateway) {
        this.taxNumerAvailableUseCase = taxNumerAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }
    @Override
    public void create(User user, String pin) throws TaxNumberException, TransactionPinException {
        validateAvaliable(user);

        TransactionPin transactionPin = new TransactionPin(pin);
        Wallet wallet = new Wallet(transactionPin, BigDecimal.ZERO, user);

        if(!createUserGateway.create(user, wallet)){
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }

    private void validateAvaliable(User user) throws TaxNumberException {
        if(!taxNumerAvailableUseCase.isTaxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.isEmailAvailable(user.getEmail())){
            throw new TaxNumberException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }
    }
}
