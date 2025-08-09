package br.com.hexagonal.application.usecaseimpl;

import br.com.hexagonal.application.gateway.NotificationGateway;
import br.com.hexagonal.core.domain.Transaction;
import br.com.hexagonal.usacase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {

    private final NotificationGateway notificationGateway;

    public UserNotificationUseCaseImpl(NotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return notificationGateway.notificate(transaction, email);
    }
}
