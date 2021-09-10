package com.modeladosemanticos.sistemadebecas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PadreDTO {

    private String nombre;
    private String apellido;
    private Integer edad;
    private String ocupacion;
    private String direccionTrabajo;
    private Double ingresosNetos;
    private Boolean convive;

}
