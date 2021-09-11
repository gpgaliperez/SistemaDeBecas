package com.modeladosemanticos.sistemadebecas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstitutoDTO {
    @NotBlank(message = "El instituto no puede tener un cue vacio.")
    private Integer cue;
}
