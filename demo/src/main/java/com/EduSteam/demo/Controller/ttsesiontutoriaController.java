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
    private ttsesiontutoriaService sesionService;

    @GetMapping
    public ResponseEntity<List<ttsesiontutoriaEntity>> listarActivos() {
        return new ResponseEntity<>(sesionService.listarActivos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ttsesiontutoriaEntity> registrar(@RequestBody ttsesiontutoriaDto dto) {
        return new ResponseEntity<>(sesionService.registrar(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLogico(@PathVariable Long id) {
        sesionService.eliminarLogico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}