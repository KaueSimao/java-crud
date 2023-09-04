package com.example.estudantescrud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EstudantesRequest(
        @NotBlank(message = "Nome não pode estar em branco") String name,

        String email,

        @NotNull(message = "RG não pode estar em branco") String rg,

        @NotNull(message = "Telefone não pode estar em branco") String telefone) 
        {

}
