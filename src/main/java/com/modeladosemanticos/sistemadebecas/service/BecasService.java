package com.modeladosemanticos.sistemadebecas.service;

import com.modeladosemanticos.sistemadebecas.domain.*;
import com.modeladosemanticos.sistemadebecas.domain.enums.EstadoBeca;
import com.modeladosemanticos.sistemadebecas.dto.AlumnoDTO;
import com.modeladosemanticos.sistemadebecas.dto.BecaDTO;
import com.modeladosemanticos.sistemadebecas.dto.FormularioDTO;
import com.modeladosemanticos.sistemadebecas.dto.PadreDTO;
import com.modeladosemanticos.sistemadebecas.exceptions.CustomException;
import com.modeladosemanticos.sistemadebecas.repository.*;
import org.dozer.DozerBeanMapper;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BecasService implements IBecasService{

    private BecasRepository becasRepository;
    private AlumnoRepository alumnoRepository;
    private OntologiasService ontology;
    private InstitutoRepository institutoRepository;
    DozerBeanMapper mapper;

    public BecasService(BecasRepository repository, InstitutoRepository institutoRepository, AlumnoRepository alumnoRepository){
        this.becasRepository = repository;
        this.alumnoRepository = alumnoRepository;
        this.institutoRepository = institutoRepository;
        this.mapper = new DozerBeanMapper();
    }

    public BecaDTO newBeca(FormularioDTO formularioDTO) throws CustomException {
        AlumnoDTO alumnoDTO = formularioDTO.getAlumno();
        Instituto instituto;
        Optional institutoOptional = institutoRepository.findById(alumnoDTO.getInstituto().getCue());

        //VALIDAR EXISTENCIA INSTITUTO
        if(!institutoOptional.isPresent()){
            throw new CustomException("Error, el instituto con cue:" +
                     alumnoDTO.getInstituto().getCue() + " no existe");
        }else{
            instituto = (Instituto) institutoOptional.get();
        }

        List<Padre> padres = new ArrayList<>();
        List<Hermano> hermanos = new ArrayList<>();
        alumnoDTO.getPadre().forEach(padre -> padres.add(mapper.map(padre, Padre.class )));
        alumnoDTO.getHermano().forEach(hermano -> hermanos.add(mapper.map(hermano, Hermano.class )));

        // CALCULAR GASTOS
        Double ingresoFamiliar = 0.0;
        Double diferenciaIngesosGastos = 0.0;
        for(PadreDTO p: alumnoDTO.getPadre()){
            ingresoFamiliar+= p.getIngresosNetos();
        }
        diferenciaIngesosGastos = ingresoFamiliar - formularioDTO.getGastosPorEnfermedad();

        //CONTAR CANT HERMANOS
        Integer cantHermanos = hermanos.size();

        //GUARDAR ALUMNO y BECA
        Alumno newAlumno = mapper.map(alumnoDTO, Alumno.class);
        newAlumno.setHermano(hermanos);
        newAlumno.setPadre(padres);
        newAlumno.setInstituto(instituto);

        Beca newBeca = new Beca(formularioDTO.getPoseeEnfermedad(),
                diferenciaIngesosGastos, EstadoBeca.ENESTUDIO,
                null,cantHermanos, newAlumno);

        newAlumno.setBeca(newBeca);
        becasRepository.save(newBeca);

        HTTPRepository repository = new HTTPRepository("http://localhost:7200/repositories/test");
        RepositoryConnection connection = repository.getConnection();
        ontology = new OntologiasService(connection);
        ontology.guardarData(alumnoRepository.save(newAlumno));
        //connection.close();

        return mapper.map(newBeca, BecaDTO.class);
    }

    public BecaDTO findById(Integer id) throws CustomException {
        if(becasRepository.findById(id).isPresent())
            return mapper.map(becasRepository.findById(id).get(), BecaDTO.class);
        else
            throw new CustomException("Error, la beca de id: " +id+ " no se encontró.");
    }

    public BecaDTO findByAlumno(Integer id) throws CustomException {
        if(alumnoRepository.findById(id).isPresent()){
            Alumno a = alumnoRepository.findById(id).get();

            if(becasRepository.findByAlumno(a).isPresent())
                return mapper.map(becasRepository.findByAlumno(a).get(), BecaDTO.class);

            return null;
        }else{
            throw new CustomException("Error, el alumno de id: " +id+ " no se encontró.");
        }
    }

    public List<BecaDTO> findByInstituto(Integer cue) throws CustomException {
        if(institutoRepository.findById(cue).isPresent()) {
            List<Alumno> alumnosDeInstituto = institutoRepository.findById(cue).get().getAlumnos();

            List<BecaDTO> becas = new ArrayList<>();
            alumnosDeInstituto.forEach(alumno -> becas.add(mapper.map(alumno.getBeca(), BecaDTO.class )));

            return becas;
        }else {
            throw new CustomException("Error, no se encontró el instituto de cue " + cue);
        }
    }

    public boolean deleteById(Integer id) throws CustomException{
        if(becasRepository.findById(id).isPresent()) {
            becasRepository.delete(becasRepository.findById(id).get());

            return !becasRepository.findById(id).isPresent();
        }else {
            throw new CustomException("Error, la beca de id: " + id + " no existe.");
        }
    }
}
