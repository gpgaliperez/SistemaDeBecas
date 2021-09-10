package com.modeladosemanticos.sistemadebecas.repository;

import com.modeladosemanticos.sistemadebecas.domain.Beca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BecasRepository extends JpaRepository<Beca, Integer> {

}
