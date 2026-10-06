package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.tetutorEntity;
import com.EduSteam.demo.Service.tetutorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tutores")
@Tag(name = "Controlador de tutores", description = "Es el controlador que te permite registrar, listar, actualizar y eliminar los tutores")
public class tetutorController {

    @Autowired
    private tetutorService tutorService;

    @GetMapping("/listar_tutor")
    public List<tetutorEntity> listar_tutores() {

        return tutorService.listar();
    }

    @GetMapping("/listar_tutor/{idtutor}")
    public tetutorEntity listar_por_id(@PathVariable("idtutor") Long idtutor) {
        tetutorEntity tutor = tutorService.listarId(idtutor);
        if (tutor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el tutor con id: " + idtutor);
        }
        return tutor;
    }

    @PostMapping("/savetutor")
    public tetutorEntity guardar_datos(@RequestBody tetutorEntity tetutor) {

        return tutorService.guardar(tetutor);
    }

    @PutMapping("/actualizartutor")
    public tetutorEntity actualizar_datos(@RequestBody tetutorEntity tetutor) {

        return tutorService.actualizar(tetutor);
    }

    @DeleteMapping("/eliminartutor/{idtutor}")
    public void eliminar_tutor(@PathVariable("idtutor") Long idtutor) {

        tutorService.eliminar(idtutor);
    }
}