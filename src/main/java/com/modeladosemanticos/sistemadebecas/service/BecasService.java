package com.modeladosemanticos.sistemadebecas.service;

import com.modeladosemanticos.sistemadebecas.domain.Hermano;
import com.modeladosemanticos.sistemadebecas.domain.Padre;
import com.modeladosemanticos.sistemadebecas.dto.AlumnoDTO;
import com.modeladosemanticos.sistemadebecas.dto.BecaDTO;
import com.modeladosemanticos.sistemadebecas.dto.FormularioDTO;
import com.modeladosemanticos.sistemadebecas.repository.BecasRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@Service
public class BecasService implements IBecasService{

    private BecasRepository repository;
    DozerBeanMapper mapper;


    public BecasService(BecasRepository repository, DozerBeanMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public BecaDTO newBeca(AlumnoDTO alumnoDTO) {

        Padre padre = mapper.map(alumnoDTO.getPadre(), Padre.class );
        List<Hermano> hermano = mapper.map(alumnoDTO.getHermano(), Hermano.class);
        alumnoDTO.stream().map( a -> )


        return null;
    }

    /*
    HACER QUERY
    Para devolver cantidad de hermanos
    Para devolver la resta entre ingresos-gastos
    SETEAR TODAS LAS BECAS CREADAS COMO EN REVISIÓN
     */


}
