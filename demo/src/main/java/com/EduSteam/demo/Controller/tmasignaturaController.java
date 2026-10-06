package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.tmasignaturaEntity;
import com.EduSteam.demo.Service.tmasignaturaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
@Tag(name = "Controlador de asignaturas", description = "Es el controlador que te permite registrar, listar, actualizar y eliminar las asignaturas")
public class tmasignaturaController {

    @Autowired
    private tmasignaturaService asignaturaService;

    @GetMapping("/listar_asignatura")
    public List<tmasignaturaEntity> listar_asignaturas() {

        return asignaturaService.listar();
    }

    @GetMapping("/listar_asignatura/{idasignatura}")
    public tmasignaturaEntity listar_por_id(@PathVariable("idasignatura") Long idasignatura) {
        tmasignaturaEntity asignatura = asignaturaService.listarId(idasignatura);
        if (asignatura == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la asignatura con id: " + idasignatura);
        }
        return asignatura;
    }

    @PostMapping("/saveasignatura")
    public tmasignaturaEntity guardar_datos(@RequestBody tmasignaturaEntity tmasignatura) {

        return asignaturaService.guardar(tmasignatura);
    }

    @PutMapping("/actualizarasignatura")
    public tmasignaturaEntity actualizar_datos(@RequestBody tmasignaturaEntity tmasignatura) {

        return asignaturaService.actualizar(tmasignatura);
    }

    @DeleteMapping("/eliminarasignatura/{idasignatura}")
    public void eliminar_asignatura(@PathVariable("idasignatura") Long idasignatura) {

        asignaturaService.eliminar(idasignatura);
    }
}