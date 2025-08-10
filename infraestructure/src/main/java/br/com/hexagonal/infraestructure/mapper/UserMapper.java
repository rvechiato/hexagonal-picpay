package br.com.hexagonal.infraestructure.mapper;

import br.com.hexagonal.core.domain.TaxNumber;
import br.com.hexagonal.core.domain.User;
import br.com.hexagonal.infraestructure.dto.request.CreateUserRequest;
import br.com.hexagonal.infraestructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toUserEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullName(),
                user.getUserType(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public User toUser(CreateUserRequest request){
        return new User(
                request.email(),
                request.password(),
                new TaxNumber(request.taxNumber()),
                request.fullName(),
                request.typeEnum()
        );
    }

    public User toUser(UserEntity user){
        return new User(
                user.getEmail(),
                user.getPassword(),
                new TaxNumber(user.getTaxNumber()),
                user.getFulname(),
                user.getType()
        );
    }
}
