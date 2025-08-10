package br.com.hexagonal.infraestructure.service;

import br.com.hexagonal.application.gateway.FindWalletByTaxNumberGateway;
import br.com.hexagonal.core.domain.Wallet;
import br.com.hexagonal.infraestructure.mapper.WalletMapper;
import br.com.hexagonal.infraestructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {

    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) {
        return walletMapper.toWallet(walletEntityRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
