package br.com.hexagonal.entity;

import br.com.hexagonal.core.domain.enuns.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "tax_number",nullable = false)
    private String taxNumber;

    @Column(name = "type_user",nullable = false)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum type;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    public UserEntity(UUID id, String email, String password, String taxNumber, UserTypeEnum type) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }
}
