package com.modeladosemanticos.sistemadebecas.domain;

import com.modeladosemanticos.sistemadebecas.domain.enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne
    @JoinColumn(name = "nro_beca")
    private Beca beca;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Instituto instituto;

    @OneToMany
    @JoinColumn(name = "sibling_id")
    private List<Hermano> hermano;

    @OneToMany
    @JoinColumn(name = "parent_id")
    private List<Padre> padre;

}
