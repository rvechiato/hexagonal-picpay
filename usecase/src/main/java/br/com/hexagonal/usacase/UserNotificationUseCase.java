package br.com.hexagonal.usacase;

import br.com.hexagonal.core.domain.Transaction;

public interface UserNotificationUseCase {
    Boolean notificate(Transaction transaction, String email);
}
