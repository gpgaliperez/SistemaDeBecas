package com.modeladosemanticos.sistemadebecas.domain;

import com.modeladosemanticos.sistemadebecas.domain.enums.EstadoBeca;
import com.modeladosemanticos.sistemadebecas.domain.enums.TipoBeca;

import javax.persistence.*;

@Entity
public class Beca {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean poseeEnfermedad;
    private Double diferenciaIngresosGastos;
    @Enumerated(EnumType.STRING)
    private EstadoBeca estadoBeca;
    @Enumerated(EnumType.STRING)
    private TipoBeca tipoBeca;
    private Integer cantidadHermanos;


    public Beca() {
    }

    public Beca(Boolean poseeEnfermedad, Double diferenciaIngresosGastos, EstadoBeca estadoBeca, TipoBeca tipoBeca, Integer cantidadHermanos) {
        this.poseeEnfermedad = poseeEnfermedad;
        this.diferenciaIngresosGastos = diferenciaIngresosGastos;
        this.estadoBeca = estadoBeca;
        this.tipoBeca = tipoBeca;
        this.cantidadHermanos = cantidadHermanos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPoseeEnfermedad() {
        return poseeEnfermedad;
    }

    public void setPoseeEnfermedad(Boolean poseeEnfermedad) {
        this.poseeEnfermedad = poseeEnfermedad;
    }

    public Double getDiferenciaIngresosGastos() {
        return diferenciaIngresosGastos;
    }

    public void setDiferenciaIngresosGastos(Double diferenciaIngresosGastos) {
        this.diferenciaIngresosGastos = diferenciaIngresosGastos;
    }

    public EstadoBeca getEstadoBeca() {
        return estadoBeca;
    }

    public void setEstadoBeca(EstadoBeca estadoBeca) {
        this.estadoBeca = estadoBeca;
    }

    public TipoBeca getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(TipoBeca tipoBeca) {
        this.tipoBeca = tipoBeca;
    }

    public Integer getCantidadHermanos() {
        return cantidadHermanos;
    }

    public void setCantidadHermanos(Integer cantidadHermanos) {
        this.cantidadHermanos = cantidadHermanos;
    }
}
