package com.modeladosemanticos.sistemadebecas.repository;

import com.modeladosemanticos.sistemadebecas.domain.Alumno;
import com.modeladosemanticos.sistemadebecas.domain.Beca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BecasRepository extends JpaRepository<Beca, Integer> {
    Optional<Beca> findByAlumno(Alumno alumno);
}
