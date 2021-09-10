package com.modeladosemanticos.sistemadebecas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name="children_id")
    private Alumno alumno;

}
