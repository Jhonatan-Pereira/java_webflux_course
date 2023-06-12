package br.com.rontec.webfluxcourse.mapper;

import br.com.rontec.webfluxcourse.entity.User;
import br.com.rontec.webfluxcourse.model.request.UserRequest;
import br.com.rontec.webfluxcourse.model.response.UserResponse;
import org.mapstruct.*;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS
)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(final UserRequest request);

    @Mapping(target = "id", ignore = true)
    User toEntity(final UserRequest request, @MappingTarget final User user);

    UserResponse toResponse(final User entity);
}
