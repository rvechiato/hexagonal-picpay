package br.com.hexagonal.infraestructure.mapper;

import br.com.hexagonal.core.domain.Wallet;
import br.com.hexagonal.infraestructure.entity.TransactionPinEntity;
import br.com.hexagonal.infraestructure.entity.UserEntity;
import br.com.hexagonal.infraestructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPin){

        return new WalletEntity(wallet.getBalance(),
                userEntity,
                transactionPin,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }
}
