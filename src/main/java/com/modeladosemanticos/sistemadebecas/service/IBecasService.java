package com.modeladosemanticos.sistemadebecas.service;

import com.modeladosemanticos.sistemadebecas.dto.BecaDTO;
import com.modeladosemanticos.sistemadebecas.dto.FormularioDTO;
import com.modeladosemanticos.sistemadebecas.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IBecasService {

    BecaDTO newBeca(FormularioDTO formularioDTO) throws ResourceNotFoundException;
    BecaDTO findById(Integer id) throws ResourceNotFoundException;
    BecaDTO findByAlumno(Integer id) throws ResourceNotFoundException;
    List<BecaDTO> findByInstituto(Integer cue) throws ResourceNotFoundException;
    boolean deleteById(Integer id) throws ResourceNotFoundException;
}
