package br.com.hexagonal.infraestructure.controller;

import br.com.hexagonal.core.exception.TaxNumberException;
import br.com.hexagonal.core.exception.TransactionPinException;
import br.com.hexagonal.infraestructure.dto.request.CreateUserRequest;
import br.com.hexagonal.infraestructure.dto.response.BaseResponse;
import br.com.hexagonal.infraestructure.mapper.UserMapper;
import br.com.hexagonal.usacase.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.hexagonal.infraestructure.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping()
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws TaxNumberException, TransactionPinException {
        log.info("Inicio da criacao do usuario::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());

        log.info("Usuario criado com sucesso::UserController");
        return BaseResponse.<String>builder().success(true).message("Usuario criado com sucesso").build();
    }
}
