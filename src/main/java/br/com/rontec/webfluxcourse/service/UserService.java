package br.com.rontec.webfluxcourse.service;

import br.com.rontec.webfluxcourse.entity.User;
import br.com.rontec.webfluxcourse.mapper.UserMapper;
import br.com.rontec.webfluxcourse.model.request.UserRequest;
import br.com.rontec.webfluxcourse.repository.UserRepository;
import br.com.rontec.webfluxcourse.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }

    public Mono<User> findById(final String id) {
        return repository.findById(id).switchIfEmpty(Mono.error(
                new ObjectNotFoundException(
                        format("Object not found. Id: %s, Type: %s", id, User.class.getSimpleName())
                )
        ));
    }
}
