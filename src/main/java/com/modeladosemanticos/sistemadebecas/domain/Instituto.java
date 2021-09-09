package com.modeladosemanticos.sistemadebecas.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Instituto {
    @Id
    private Integer cue;
    private Integer clave;
    //ver la relacion con alumnos
    @OneToMany(targetEntity = Alumno.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alumno> alumnos;


    public Instituto() {
    }

    public Instituto(Integer cue, Integer clave, List<Alumno> alumnos) {
        this.cue = cue;
        this.clave = clave;
        this.alumnos = alumnos;
    }

    public Integer getCue() {
        return cue;
    }

    public void setCue(Integer cue) {
        this.cue = cue;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
