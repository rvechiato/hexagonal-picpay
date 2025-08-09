package br.com.hexagonal.infraestructure.config;

import br.com.hexagonal.application.gateway.CreateUserGateway;
import br.com.hexagonal.application.gateway.EmailAvailableGateway;
import br.com.hexagonal.application.gateway.TaxNumberAvailableGateway;
import br.com.hexagonal.application.usecaseimpl.CreateUserUseCaseImpl;
import br.com.hexagonal.application.usecaseimpl.EmailAvailableUseCaseImpl;
import br.com.hexagonal.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import br.com.hexagonal.usacase.CreateUserUseCase;
import br.com.hexagonal.usacase.EmailAvailableUseCase;
import br.com.hexagonal.usacase.TaxNumerAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {


    @Bean
    public TaxNumerAvailableUseCase taxNumerAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableGateway(EmailAvailableGateway emailAvailableGateway){
        return  new EmailAvailableUseCaseImpl(emailAvailableGateway);

    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumerAvailableUseCase taxNumerAvailableUseCase,
                                               EmailAvailableUseCase emailAvailableUseCase,
                                               CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(taxNumerAvailableUseCase, emailAvailableUseCase, createUserGateway);

    }
}
