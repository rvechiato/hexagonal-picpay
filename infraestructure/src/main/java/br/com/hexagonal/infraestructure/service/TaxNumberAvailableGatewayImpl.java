package br.com.hexagonal.infraestructure.service;

import br.com.hexagonal.application.gateway.TaxNumberAvailableGateway;
import br.com.hexagonal.infraestructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.com.hexagonal.infraestructure.utils.Utilities.log;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        log.info("Inicio de verificacao se o taxnumber esta dispinivel!");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
