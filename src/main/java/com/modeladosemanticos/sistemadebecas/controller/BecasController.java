package com.modeladosemanticos.sistemadebecas.controller;

import com.modeladosemanticos.sistemadebecas.dto.*;

import com.modeladosemanticos.sistemadebecas.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.modeladosemanticos.sistemadebecas.service.BecasService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/beca")
public class BecasController {

    @Autowired
    BecasService becaSrv;


    @PostMapping("/newBeca")
    public ResponseEntity<?> newBeca(@RequestBody @Valid FormularioDTO formularioDTO) throws CustomException {

        return new ResponseEntity(becaSrv.newBeca(formularioDTO), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BecaDTO> findById(@PathVariable Integer id) throws CustomException {
            return new ResponseEntity(becaSrv.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/alumno/{id}")
    public ResponseEntity<BecaDTO> findByAlumno(@PathVariable Integer id) throws CustomException {
        return new ResponseEntity(becaSrv.findByAlumno(id), HttpStatus.OK);
    }

    @GetMapping(path = "/instituto/{cue}")
    public ResponseEntity<BecaDTO> findByInstituto(@PathVariable Integer cue) throws CustomException {
        return new ResponseEntity(becaSrv.findByInstituto(cue), HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) throws CustomException {
        return new ResponseEntity(becaSrv.deleteById(id), HttpStatus.OK);

    }
}
