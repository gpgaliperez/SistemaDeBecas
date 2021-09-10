package com.modeladosemanticos.sistemadebecas.repository;

import com.modeladosemanticos.sistemadebecas.domain.Alumno;
import com.modeladosemanticos.sistemadebecas.domain.Beca;
import com.modeladosemanticos.sistemadebecas.dto.BecaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BecasRepository extends JpaRepository<Beca, Integer> {

}
