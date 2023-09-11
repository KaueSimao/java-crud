package com.example.estudantescrud.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.estudantescrud.dtos.EstudantesRequest;
import com.example.estudantescrud.dtos.EstudantesResponse;
import com.example.estudantescrud.entites.Estudantes;


public class EstudantesMapper {
    public static Estudantes toEntity(EstudantesRequest request){
        Estudantes estudantes = new Estudantes();
        estudantes.setName(request.name());
        estudantes.setEmail(request.email());
        estudantes.setRg(request.rg());
        estudantes.setTelefone(request.telefone());
        return estudantes;
    }

    public static EstudantesResponse toDTO(Estudantes estudantes){
        return new EstudantesResponse(estudantes.getId(),
                estudantes.getName(),
                estudantes.getEmail(),
                estudantes.getRg(),
                estudantes.getTelefone());
    }
    public static List<EstudantesResponse> toDTOList(List<Estudantes> estudantes){
        return estudantes.stream()
                .map(EstudantesMapper::toDTO)
                .collect(Collectors.toList());
    }
}
