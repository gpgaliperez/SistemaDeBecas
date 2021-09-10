package com.modeladosemanticos.sistemadebecas.dto;

import com.modeladosemanticos.sistemadebecas.domain.enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {
    private String nombre;
    private String apellido;
    private Integer dni;
    private String cuil;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String localidad;
    private String domicilio;
    private Integer codigoPostal;
    private Integer telefono;
    private String email;
    @Enumerated(EnumType.STRING)
    private Turno turno;
    private Integer grado;
    private List<HermanoDTO> hermano;
    private List<PadreDTO> padre;
    private InstitutoDTO instituto;

}
