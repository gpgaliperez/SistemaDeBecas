package com.modeladosemanticos.sistemadebecas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.modeladosemanticos.sistemadebecas.domain.enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {
    @NotBlank(message = "El nombre no puede estar vacio.")
    private String nombre;
    @NotBlank(message = "El apellido no puede estar vacio.")
    private String apellido;
    @NotNull(message = "El dni no puede estar vacio.")
    @Size(max = 10)
    private Integer dni;
    @NotNull(message = "El cuil no puede estar vacio.")
    @Size(max = 11)
    private String cuil;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaNacimiento;
    private String nacionalidad;
    private String localidad;
    private String domicilio;
    private String codigoPostal;
    private String telefono;
    @Email(message = "Ingrese un email valido")
    private String email;
    @Enumerated(EnumType.STRING)
    private Turno turno;
    private Integer grado;
    @Valid
    private List<HermanoDTO> hermano;
    @Valid
    private List<PadreDTO> padre;
    @Valid
    private InstitutoDTO instituto;

}
