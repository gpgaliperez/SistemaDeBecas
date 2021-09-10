package com.modeladosemanticos.sistemadebecas.repository;

import com.modeladosemanticos.sistemadebecas.domain.Instituto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutoRepository extends JpaRepository<Instituto, Integer> {
}
