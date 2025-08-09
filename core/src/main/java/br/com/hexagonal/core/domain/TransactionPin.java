package br.com.hexagonal.core.domain;

import br.com.hexagonal.core.domain.enuns.ErrorCodeEnum;
import br.com.hexagonal.core.exception.TransactionPinException;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionPin {
    private long id;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin(long id,  String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(String pin) throws TransactionPinException {
        this.setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    private void pinIsValid(String pin) throws TransactionPinException {
        if(pin.length() != 8) {
            throw new TransactionPinException(ErrorCodeEnum.TRP001.getMessage(), ErrorCodeEnum.TRP001.getCode());
        }
    }

    public void setPin(String pin) throws TransactionPinException {
        pinIsValid(pin);
        this.pin = pin;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt() {
        if(this.attempt == 1){
            this.blocked = true;
            this.attempt = 0;
        }

        this.attempt = this.attempt -1;
    }

    public void resetAttempt() {
        this.attempt=3;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionPin that = (TransactionPin) o;
        return id == that.id && Objects.equals(pin, that.pin) && Objects.equals(attempt, that.attempt) && Objects.equals(blocked, that.blocked) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pin, attempt, blocked, createdAt, updatedAt);
    }
}

