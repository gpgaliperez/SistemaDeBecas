package com.modeladosemanticos.sistemadebecas.dto;

import com.modeladosemanticos.sistemadebecas.domain.Beca;
import com.modeladosemanticos.sistemadebecas.domain.Hermano;
import com.modeladosemanticos.sistemadebecas.domain.Instituto;
import com.modeladosemanticos.sistemadebecas.domain.Padre;
import com.modeladosemanticos.sistemadebecas.domain.enums.Turno;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class FormularioDTO {






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
