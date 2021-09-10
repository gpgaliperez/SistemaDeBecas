package com.modeladosemanticos.sistemadebecas.service;

import com.modeladosemanticos.sistemadebecas.domain.Alumno;
import com.modeladosemanticos.sistemadebecas.domain.Beca;
import com.modeladosemanticos.sistemadebecas.domain.Hermano;
import com.modeladosemanticos.sistemadebecas.domain.Padre;
import com.modeladosemanticos.sistemadebecas.domain.enums.EstadoBeca;
import com.modeladosemanticos.sistemadebecas.domain.enums.TipoBeca;
import com.modeladosemanticos.sistemadebecas.dto.AlumnoDTO;
import com.modeladosemanticos.sistemadebecas.dto.BecaDTO;
import com.modeladosemanticos.sistemadebecas.dto.FormularioDTO;
import com.modeladosemanticos.sistemadebecas.exceptions.ResourceNotFoundException;
import com.modeladosemanticos.sistemadebecas.repository.AlumnoRepository;
import com.modeladosemanticos.sistemadebecas.repository.BecasRepository;
import com.modeladosemanticos.sistemadebecas.repository.InstitutoRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BecasService implements IBecasService{

    private BecasRepository becasRepository;
    private AlumnoRepository alumnoRepository;
    private InstitutoRepository institutoRepository;
    DozerBeanMapper mapper;


    public BecasService(BecasRepository repository, InstitutoRepository institutoRepository){
        this.becasRepository = repository;
        this.institutoRepository = institutoRepository;
        this.mapper = new DozerBeanMapper();
    }

    public BecaDTO newBeca(FormularioDTO formularioDTO) throws ResourceNotFoundException {
        AlumnoDTO alumnoDTO = formularioDTO.getAlumno();

        //VALIDAR EXISTENCIA INSTITUTO
        if(!institutoRepository.findById(alumnoDTO.getInstituto().getCue()).isPresent()){
            throw new ResourceNotFoundException("Error, el instituto con cue:" +
                     alumnoDTO.getInstituto().getCue() + " no existe");
        }

        List<Padre> padres = alumnoDTO.getPadre().stream().map( a -> mapper.map(alumnoDTO.getPadre(), Padre.class )).collect(Collectors.toList());
        List<Hermano> hermanos = alumnoDTO.getHermano().stream().map( a -> mapper.map(alumnoDTO.getHermano(), Hermano.class)).collect(Collectors.toList());

        // CALCULAR GASTOS
        Double ingresoFamiliar = 0.0;
        Double diferenciaIngesosGastos = 0.0;
        for(Padre p: padres){
            ingresoFamiliar+= p.getIngresosNetos();
        }
        diferenciaIngesosGastos = ingresoFamiliar - formularioDTO.getDiferenciaIngresosGastos();

        //CONTAR CANT HERMANOS
        Integer cantHermanos = hermanos.size();

        //GUARDAR ALUMNO y BECA
        Alumno newAlumno = mapper.map(alumnoDTO, Alumno.class);
        newAlumno.setHermano(hermanos);
        newAlumno.setPadre(padres);

        Beca newBeca = new Beca(formularioDTO.getPoseeEnfermedad(),
                diferenciaIngesosGastos, EstadoBeca.ENESTUDIO,
                null,cantHermanos, newAlumno);

        newAlumno.setBeca(newBeca);
        becasRepository.save(newBeca);
        return mapper.map(newBeca, BecaDTO.class);
    }

    public BecaDTO findByAlumno(Integer id){
        try{
            if(alumnoRepository.findById(id).isPresent()){
                Alumno a = alumnoRepository.findById(id).get();

                if(becasRepository.findByAlumno(a).isPresent())
                    return mapper.map(becasRepository.findByAlumno(a).get(), BecaDTO.class);
                else
                    return null;
            }else{
                return null;
            }
        } catch ( Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public BecaDTO findById(Integer id){
        try{
            if(becasRepository.findById(id).isPresent())
                return mapper.map(becasRepository.findById(id).get(), BecaDTO.class);
            else
                return null;
        } catch ( Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }


    /*
    HACER QUERY
    Para devolver cantidad de hermanos
    Para devolver la resta entre ingresos-gastos
    SETEAR TODAS LAS BECAS CREADAS COMO EN REVISIÓN
     */

}
