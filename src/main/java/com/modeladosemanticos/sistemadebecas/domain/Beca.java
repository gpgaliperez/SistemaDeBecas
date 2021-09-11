package com.modeladosemanticos.sistemadebecas.domain;

import com.modeladosemanticos.sistemadebecas.domain.enums.EstadoBeca;
import com.modeladosemanticos.sistemadebecas.domain.enums.TipoBeca;
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
public class Beca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private Boolean poseeEnfermedad;
    private Double diferenciaIngresosGastos;
    @Enumerated(EnumType.STRING)
    private EstadoBeca estadoBeca;
    @Enumerated(EnumType.STRING)
    private TipoBeca tipoBeca;
    private Integer cantidadHermanos;
    @OneToOne(mappedBy = "beca", cascade = CascadeType.PERSIST)
    private Alumno alumno;

    public Beca(Boolean poseeEnfermedad, Double diferenciaIngresosGastos, EstadoBeca estadoBeca, TipoBeca tipoBeca, Integer cantidadHermanos, Alumno alumno) {
        this.poseeEnfermedad = poseeEnfermedad;
        this.diferenciaIngresosGastos = diferenciaIngresosGastos;
        this.estadoBeca = estadoBeca;
        this.tipoBeca = tipoBeca;
        this.cantidadHermanos = cantidadHermanos;
        this.alumno = alumno;
    }
}
