package br.com.hexagonal.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_wallet")
@AllArgsConstructor
@NoArgsConstructor
public class WalletEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "balance")
    private BigDecimal Balance;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "transactionPinId" ,nullable = false)
    private TransactionPinEntity transactionPinEntity;

    @Column(name = "create_at",nullable = false)
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public WalletEntity(BigDecimal balance, UserEntity userEntity, TransactionPinEntity transactionPinEntity, LocalDateTime createAt, LocalDateTime updateAt) {
        Balance = balance;
        this.userEntity = userEntity;
        this.transactionPinEntity = transactionPinEntity;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}

