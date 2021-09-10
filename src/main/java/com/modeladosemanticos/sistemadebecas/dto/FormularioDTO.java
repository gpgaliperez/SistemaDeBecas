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

}
