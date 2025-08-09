package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.EmailAvailableGateway;
import br.com.hexagonal.usacase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private final EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean isEmailAvailable(String email) {
       return emailAvailableGateway.emailAvailable(email);
    }
}
