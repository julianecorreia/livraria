package br.unipar.programacaoweb.livraria.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LoginResponse(
        @NotNull @NotEmpty @NotBlank String username,
        @NotNull @NotEmpty @NotBlank String token
) { }
