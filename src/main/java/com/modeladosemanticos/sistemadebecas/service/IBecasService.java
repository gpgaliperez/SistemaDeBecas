package com.modeladosemanticos.sistemadebecas.service;

import com.modeladosemanticos.sistemadebecas.dto.AlumnoDTO;
import com.modeladosemanticos.sistemadebecas.dto.BecaDTO;

public interface IBecasService {

    BecaDTO newBeca(AlumnoDTO formularioDTO);
}
