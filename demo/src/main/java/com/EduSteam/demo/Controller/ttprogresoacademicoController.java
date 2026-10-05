package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import com.EduSteam.demo.Service.ttprogresoacademicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progresosacademicos")
@Tag(name = "Controlador de Progreso Académico", description = "Permite registrar, listar, consultar, actualizar y eliminar el progreso académico")
public class ttprogresoacademicoController {

    @Autowired
    private ttprogresoacademicoService service;

    @GetMapping
    @Operation(summary = "Listar todos los progresos académicos")
    public List<ttprogresoacademicoEntity> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un progreso académico por su id")
    public ttprogresoacademicoEntity obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Guardar un nuevo progreso académico")
    public ttprogresoacademicoEntity guardar(@RequestBody ttprogresoacademicoEntity progreso) {
        return service.guardar(progreso);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un progreso académico existente")
    public ttprogresoacademicoEntity actualizar(@PathVariable Long id, @RequestBody ttprogresoacademicoEntity progreso) {
        return service.actualizar(id, progreso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Eliminar un progreso académico")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}