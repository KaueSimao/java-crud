package com.example.estudantescrud.repositories;
import com.example.estudantescrud.entites.Estudantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudantesRepository extends JpaRepository<Estudantes, Long> {

}
