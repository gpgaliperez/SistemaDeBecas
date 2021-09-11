package com.modeladosemanticos.sistemadebecas.dto;

import com.modeladosemanticos.sistemadebecas.domain.Alumno;
import com.modeladosemanticos.sistemadebecas.domain.enums.EstadoBeca;
import com.modeladosemanticos.sistemadebecas.domain.enums.TipoBeca;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BecaDTO {

    private Integer id;
    private Boolean poseeEnfermedad;
    private Double diferenciaIngresosGastos;
    @Enumerated(EnumType.STRING)
    private EstadoBeca estadoBeca;
    @Enumerated(EnumType.STRING)
    private TipoBeca tipoBeca;
    private Integer cantidadHermanos;
    private AlumnoDTO alumno;
}
