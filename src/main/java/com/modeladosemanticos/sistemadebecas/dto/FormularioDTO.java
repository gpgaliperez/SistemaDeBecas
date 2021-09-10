package com.modeladosemanticos.sistemadebecas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormularioDTO {
    private AlumnoDTO alumno;
    private Double diferenciaIngresosGastos;
    private Boolean poseeEnfermedad;

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

    public Double getDiferenciaIngresosGastos() {
        return diferenciaIngresosGastos;
    }

    public void setDiferenciaIngresosGastos(Double diferenciaIngresosGastos) {
        this.diferenciaIngresosGastos = diferenciaIngresosGastos;
    }

    public Boolean getPoseeEnfermedad() {
        return poseeEnfermedad;
    }

    public void setPoseeEnfermedad(Boolean poseeEnfermedad) {
        this.poseeEnfermedad = poseeEnfermedad;
    }
}
