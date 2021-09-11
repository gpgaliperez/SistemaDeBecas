package com.modeladosemanticos.sistemadebecas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormularioDTO {
    @NotNull(message= "Por favor, ingrese los datos de un alumno.")
    private AlumnoDTO alumno;

    @NotEmpty(message = "Por favor, ingrese los gastos por enfermedad.")
    private Double gastosPorEnfermedad;

    @NotNull(message= "Por favor, ingrese si posee una enfermedad.")
    private Boolean poseeEnfermedad;

}
