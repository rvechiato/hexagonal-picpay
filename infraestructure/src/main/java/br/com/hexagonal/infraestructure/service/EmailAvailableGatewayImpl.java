package br.com.hexagonal.infraestructure.service;

import br.com.hexagonal.application.gateway.EmailAvailableGateway;
import br.com.hexagonal.infraestructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.com.hexagonal.infraestructure.utils.Utilities.log;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {
    private final UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        log.info("Inicio de verificacao se o taxnumber esta dispinivel!");
        return !userEntityRepository.existsByEmail(email);
    }
}
