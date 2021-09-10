package com.modeladosemanticos.sistemadebecas.repository;

import com.modeladosemanticos.sistemadebecas.domain.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}
