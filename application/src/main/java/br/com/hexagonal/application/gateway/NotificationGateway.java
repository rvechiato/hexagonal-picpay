package br.com.hexagonal.application.gateway;

import br.com.hexagonal.core.domain.Transaction;

public interface NotificationGateway {

    Boolean notificate(Transaction transaction, String email);
}
