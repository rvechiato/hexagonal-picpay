package br.com.hexagonal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_transaction_pin")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPinEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pin")
    private String pin;

    @Column(name = "attempts")
    private Integer attempts;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public TransactionPinEntity(String pin, Integer attempts, Boolean isBlocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.pin = pin;
        this.attempts = attempts;
        this.isBlocked = isBlocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
