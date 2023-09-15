package com.example.estudantescrud.resources;

import java.net.URI;
import java.util.List;


import com.example.estudantescrud.dtos.EstudantesRequest;
import com.example.estudantescrud.dtos.EstudantesResponse;
import com.example.estudantescrud.entites.Estudantes;
import com.example.estudantescrud.mappers.EstudantesMapper;
import com.example.estudantescrud.services.EstudantesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin
@RequestMapping("estudantes")
public class EstudantesController {

    @Autowired
    private EstudantesService service;

    @GetMapping
    public ResponseEntity<List<EstudantesResponse>> getEstudantes() {
        var estudantes = this.service.getEstudantes();
        return ResponseEntity.ok(EstudantesMapper.toDTOList(estudantes));
    }

    @GetMapping("{id}")
    public ResponseEntity<EstudantesResponse> getEstudante(@PathVariable long id) {
        var estudantes = this.service.getEstudante(id);
        return ResponseEntity.ok(EstudantesMapper.toDTO(estudantes));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEstudantes(@PathVariable long id) {
        this.service.deleteEstudantesById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody EstudantesRequest estudantes) {
        var savedEstudantes = this.service.save(estudantes);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEstudantes.id())
                .toUri();

        return ResponseEntity.created(location).body(savedEstudantes);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody Estudantes estudantes,
                                       @PathVariable long id) {
        this.service.update(id, estudantes);
        return ResponseEntity.ok().build();
    }
}

