package com.example.estudantescrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estudantescrud.dtos.EstudantesRequest;
import com.example.estudantescrud.dtos.EstudantesResponse;
import com.example.estudantescrud.entites.Estudantes;
import com.example.estudantescrud.mappers.EstudantesMapper;
import com.example.estudantescrud.repositories.EstudantesRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class EstudantesService {
    @Autowired
    private EstudantesRepository repository;

    public List<Estudantes> getEstudantes(){
        return this.repository.findAll();
    }
 

    public Estudantes getEstudante(long id){
        return this.repository.findById(id).orElseThrow(

                                                () -> new EntityNotFoundException("Estudante not found")
                                            );

    }

    public void deleteEstudantesById(long id) {

        if(this.repository.existsById(id)){
            this.repository.deleteById(id);

        }

        else{

            throw new EntityNotFoundException("Estudante not found");

        }
    }
    public EstudantesResponse save(EstudantesRequest product){

        var entity = this.repository.save(EstudantesMapper.toEntity(product));
        return EstudantesMapper.toDTO(entity);

    }
    public void update(long id, Estudantes estudantes) {

        try{
            var updateEstudantes = this.repository.getReferenceById(id);
            updateEstudantes.setName(estudantes.getName());
            updateEstudantes.setEmail(estudantes.getEmail());
            updateEstudantes.setRg(estudantes.getRg());
            updateEstudantes.setTelefone(estudantes.getTelefone());
            this.repository.save(updateEstudantes);
        }

        catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Estudante not found");

        }
    }


	public void deleteEstudantes(long id) {
	}
}
