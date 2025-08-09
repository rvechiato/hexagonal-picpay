package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.UserAuthenticationGateway;
import br.com.hexagonal.core.domain.enuns.ErrorCodeEnum;
import br.com.hexagonal.core.exception.AuthenticationException;
import br.com.hexagonal.usacase.UserAuthenticationUseCase;

public class UserAuthenticationUseCaseImpl implements UserAuthenticationUseCase {

    private UserAuthenticationGateway  userAuthenticationGateway;

    public UserAuthenticationUseCaseImpl(UserAuthenticationGateway userAuthenticationGateway) {
        this.userAuthenticationGateway = userAuthenticationGateway;
    }

    @Override
    public Boolean authenticate(String email, String password) {
        if(!userAuthenticationGateway.authenticate(email, password)) {
            throw new AuthenticationException(ErrorCodeEnum.AUTH001.getMessage(), ErrorCodeEnum.AUTH001.getCode());
        }
        return true;
    }
}
