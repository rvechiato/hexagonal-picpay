package br.com.hexagonal.infraestructure.entity;

import br.com.hexagonal.core.domain.enuns.TransactionStatusEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_wallet")
    private WalletEntity fromWallet;

    @ManyToOne
    @JoinColumn(name = "to_wallet")
    private WalletEntity toWallet;

    @Column(name = "transaction_value")
    private BigDecimal value;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum statusEnum;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
