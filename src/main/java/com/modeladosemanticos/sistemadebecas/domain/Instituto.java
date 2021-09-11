package com.modeladosemanticos.sistemadebecas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Instituto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer cue;
    private Integer clave;

    @OneToMany(mappedBy = "instituto", targetEntity = Alumno.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alumno> alumnos;

}


