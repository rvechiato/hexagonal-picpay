package br.com.hexagonal.infraestructure.mapper;

import br.com.hexagonal.core.domain.Wallet;
import br.com.hexagonal.infraestructure.entity.TransactionPinEntity;
import br.com.hexagonal.infraestructure.entity.UserEntity;
import br.com.hexagonal.infraestructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    private TransactionPinMapper transactionPinMapper;
    private UserMapper userMapper;

    public WalletMapper(TransactionPinMapper transactionPinMapper, UserMapper userMapper) {
        this.transactionPinMapper = transactionPinMapper;
        this.userMapper = userMapper;
    }

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPin){

        return new WalletEntity(wallet.getBalance(),
                userEntity,
                transactionPin,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }

    public WalletEntity toWalletEntity(Wallet wallet){
        return new WalletEntity(
            wallet.getBalance(),
            userMapper.toUserEntity(wallet.getUser()),
            transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()),
            wallet.getCreatedAt(),
            wallet.getUpdatedAt()
        );
    }

    public Wallet toWallet(WalletEntity walletEntity){
        if(walletEntity == null)
            return null;

        return new Wallet(
                walletEntity.getId(),
                transactionPinMapper.toTransactionPin(walletEntity.getTransactionPinEntity()),
                walletEntity.getBalance(),
                userMapper.toUser(walletEntity.getUserEntity()),
                walletEntity.getCreateAt(),
                walletEntity.getUpdateAt()
        );
    }

}
