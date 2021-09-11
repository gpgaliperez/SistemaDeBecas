package com.modeladosemanticos.sistemadebecas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.modeladosemanticos.sistemadebecas.domain.enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
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
    private Turno turno;
    private Integer grado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nro_beca")
    private Beca beca;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instituto_id")
    private Instituto instituto;

    @OneToMany(mappedBy = "alumno", targetEntity = Hermano.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hermano> hermano;

    @OneToMany(mappedBy = "alumno", targetEntity = Padre.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Padre> padre;

}
