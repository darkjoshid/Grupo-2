package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Dto.ttprogresoacademicoDto;
import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import com.EduSteam.demo.Service.ttprogresoacademicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progresosacademicos")
@Tag(name = "Controlador de Progreso Académico", description = "Permite registrar, listar, consultar, actualizar y eliminar el progreso académico")
public class ttprogresoacademicoController {

    @Autowired
    private ttprogresoacademicoService progresoService;

    @GetMapping
    public ResponseEntity<List<ttprogresoacademicoEntity>> listarActivos() {
        return new ResponseEntity<>(progresoService.listarActivos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ttprogresoacademicoEntity> registrar(@RequestBody ttprogresoacademicoDto dto) {
        return new ResponseEntity<>(progresoService.registrar(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLogico(@PathVariable Long id) {
        progresoService.eliminarLogico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}