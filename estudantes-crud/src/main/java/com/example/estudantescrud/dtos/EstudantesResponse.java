package com.example.estudantescrud.dtos;

public record EstudantesResponse(
        Long id,
        String name,
        String email,
        String rg,
        String telefone) {
}
