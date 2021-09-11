package com.modeladosemanticos.sistemadebecas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HermanoDTO {
    @NotBlank(message = "El nombre no debe estar vacío.")
    @Size(min = 4, message = "El nombre debe tener una longitud mínima de 4 letras.")
    private String nombre;

    @NotBlank(message = "El apellido no debe estar vacío.")
    @Size(min = 4, message = "El apellido debe tener una longitud mínima de 4 letras.")
    private String apellido;

    @NotEmpty(message = "Por favor, ingrese la edad.")
    private Integer edad;

    @NotEmpty(message = "Por favor, ingrese la ocupación.")
    private String ocupacion;

    @NotEmpty(message = "Por favor, ingrese la escuela.")
    private String escuela;
    private Boolean convive;

}
