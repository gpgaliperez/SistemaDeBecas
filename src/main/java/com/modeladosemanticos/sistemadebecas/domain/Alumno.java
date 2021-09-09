package com.modeladosemanticos.sistemadebecas.domain;

import com.modeladosemanticos.sistemadebecas.domain.enums.Turno;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Alumno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private String cuil;
    private Date fechaNacimiento;
    private String nacionalidad; //debería ser enum?
    private String localidad; //debería ser enum?
    private String domicilio;
    private Integer codigoPostal;
    private Integer telefono;
    private String email;
    @Enumerated(EnumType.STRING)
    private Turno turno;
    private Integer grado;

    //Ver de que lado van las relaciones:
    @OneToOne
    @JoinColumn(name = "nro_beca")
    private Beca beca;
    //private Instituto instituto;
    //Falta padres y hnos
}
