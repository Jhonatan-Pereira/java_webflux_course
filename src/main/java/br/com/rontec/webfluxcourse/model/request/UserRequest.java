package br.com.rontec.webfluxcourse.model.request;

public record UserRequest(
        String name,
        String email,
        String password
) {
}
