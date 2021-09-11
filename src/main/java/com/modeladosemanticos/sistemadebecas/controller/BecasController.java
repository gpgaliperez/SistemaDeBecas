package com.modeladosemanticos.sistemadebecas.controller;

import com.modeladosemanticos.sistemadebecas.dto.*;
import com.modeladosemanticos.sistemadebecas.exceptions.ResourceNotFoundException;
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
    public ResponseEntity<?> newBeca(@RequestBody @Valid FormularioDTO formularioDTO){
        try {
            return new ResponseEntity(becaSrv.newBeca(formularioDTO), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BecaDTO> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity(becaSrv.findById(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(path = "/alumno/{id}")
    public ResponseEntity<BecaDTO> findByAlumno(@PathVariable Integer id){
        try {
            return new ResponseEntity(becaSrv.findByAlumno(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(path = "/instituto/{cue}")
    public ResponseEntity<BecaDTO> findByInstituto(@PathVariable Integer cue){
        try {
            return new ResponseEntity(becaSrv.findByInstituto(cue), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        try {
            return new ResponseEntity(becaSrv.deleteById(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
