package br.com.hexagonal.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_wallet")
public class WalletEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "balance")
    private BigDecimal Balance;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "transactionPinId")
    private TransactionEntity transactionEntity;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

}

