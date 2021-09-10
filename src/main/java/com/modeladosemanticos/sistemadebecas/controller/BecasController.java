package com.modeladosemanticos.sistemadebecas.controller;

import com.modeladosemanticos.sistemadebecas.dto.AlumnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.modeladosemanticos.sistemadebecas.service.BecasService;

@RestController
@RequestMapping("/api/beca")
public class BecasController {

    @Autowired
    BecasService becaSrv;

    @PostMapping("/newBeca")
    public ResponseEntity<?> newBeca(@RequestBody FormularioDTO formularioDTO){
        try {
            return new ResponseEntity(becaSrv.newBeca(formularioDTO), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
