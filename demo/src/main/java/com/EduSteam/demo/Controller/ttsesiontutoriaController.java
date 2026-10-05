package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;
import com.EduSteam.demo.Service.ttsesiontutoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sesionestutoria")
@Tag(name = "Controlador de Sesiones de Tutoría", description = "Permite registrar, listar, consultar, actualizar y dar de baja sesiones de tutoría")
public class ttsesiontutoriaController {

    @Autowired
    private ttsesiontutoriaService service;

    @GetMapping
    @Operation(summary = "Listar todas las sesiones de tutoría activas")
    public List<ttsesiontutoriaEntity> listarActivas() {
        return service.listarActivas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una sesión de tutoría por su id")
    public ttsesiontutoriaEntity obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registrar una nueva sesión de tutoría")
    public ttsesiontutoriaEntity registrar(@RequestBody ttsesiontutoriaEntity sesion) {
        return service.registrar(sesion);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una sesión de tutoría existente")
    public ttsesiontutoriaEntity actualizar(@PathVariable Long id, @RequestBody ttsesiontutoriaEntity sesion) {
        return service.actualizar(id, sesion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Dar de baja lógicamente a una sesión de tutoría")
    public void eliminarLogico(@PathVariable Long id) {
        service.eliminarLogico(id);
    }
}