package br.com.rontec.webfluxcourse.service;

import br.com.rontec.webfluxcourse.entity.User;
import br.com.rontec.webfluxcourse.mapper.UserMapper;
import br.com.rontec.webfluxcourse.model.request.UserRequest;
import br.com.rontec.webfluxcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }
}
