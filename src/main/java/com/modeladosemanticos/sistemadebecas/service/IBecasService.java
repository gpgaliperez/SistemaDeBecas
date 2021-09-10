package com.modeladosemanticos.sistemadebecas.service;

import com.modeladosemanticos.sistemadebecas.dto.BecaDTO;
import com.modeladosemanticos.sistemadebecas.dto.FormularioDTO;
import com.modeladosemanticos.sistemadebecas.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IBecasService {

    BecaDTO newBeca(FormularioDTO formularioDTO) throws ResourceNotFoundException;
    BecaDTO findByAlumno(Integer id);
    BecaDTO findById(Integer id);
}
