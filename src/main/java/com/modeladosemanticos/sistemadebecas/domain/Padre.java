package com.modeladosemanticos.sistemadebecas.domain;

import javax.persistence.*;

@Entity
public class Padre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ocupacion;
    private String direccionTrabajo;
    private Double ingresosNetos;
    private Boolean convive;
    private Alumno alumno; //ver relacion
}
