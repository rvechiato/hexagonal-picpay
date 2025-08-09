package br.com.hexagonal.infraestructure.service;

import br.com.hexagonal.application.gateway.CreateUserGateway;
import br.com.hexagonal.core.domain.User;
import br.com.hexagonal.core.domain.Wallet;
import br.com.hexagonal.infraestructure.mapper.TransactionPinMapper;
import br.com.hexagonal.infraestructure.mapper.UserMapper;
import br.com.hexagonal.infraestructure.mapper.WalletMapper;
import br.com.hexagonal.infraestructure.repository.TransactionPinEntityRepository;
import br.com.hexagonal.infraestructure.repository.UserEntityRepository;
import br.com.hexagonal.infraestructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

import static br.com.hexagonal.infraestructure.utils.Utilities.log;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {

    private final UserEntityRepository userEntityRepository;
    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final UserMapper userMapper;
    private final TransactionPinMapper transactionPinMapper;
    private final WalletEntityRepository walletEntityRepository;
    private final WalletMapper walletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, TransactionPinEntityRepository transactionPinEntityRepository, UserMapper userMapper, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Boolean create(User user, Wallet wallet) {
        try{
            log.info("Inicio da criacao do usuario::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinSavad = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet, userSaved, transactionPinSavad));
            log.info("Usuario criado com sucesso::CreateUserGatewayImpl");

            return true;
        } catch (Exception ex) {
            log.error("Erro na criacao do usuario::CreateUserGatewayImpl");
            return false;
        }
    }
}
