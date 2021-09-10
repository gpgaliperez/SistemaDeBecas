package com.modeladosemanticos.sistemadebecas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HermanoDTO {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ocupacion;
    private String escuela;
    private Boolean convive;

}
