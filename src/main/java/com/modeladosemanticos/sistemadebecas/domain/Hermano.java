package com.modeladosemanticos.sistemadebecas.domain;

import javax.persistence.*;

@Entity
public class Hermano {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ocupacion;
    private String escuela;
    private Boolean convive;
    private Alumno alumno; //ver la relacion bien
}
