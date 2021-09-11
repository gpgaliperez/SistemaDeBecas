package com.modeladosemanticos.sistemadebecas.service;

import com.modeladosemanticos.sistemadebecas.domain.Beca;
import com.modeladosemanticos.sistemadebecas.dto.BecaDTO;
import com.modeladosemanticos.sistemadebecas.dto.FormularioDTO;
import com.modeladosemanticos.sistemadebecas.exceptions.CustomException;


import java.util.List;

public interface IBecasService {

    BecaDTO newBeca(FormularioDTO formularioDTO) throws CustomException;
    BecaDTO findById(Integer id) throws CustomException;
    BecaDTO findByAlumno(Integer id) throws CustomException;
    List<BecaDTO> findByInstituto(Integer cue) throws CustomException;
    boolean deleteById(Integer id) throws CustomException;
}
