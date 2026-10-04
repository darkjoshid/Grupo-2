package com.example.demo.Controller;


import com.example.demo.Entity.SesionTutoriaEntity;
import com.example.demo.Service.SesionTutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sesionestutoria")
public class SesionTutoriaController {

    @Autowired
    private SesionTutoriaService sesionTutoriaService;

    @GetMapping
    public List<SesionTutoriaEntity> listarActivas() {
        return sesionTutoriaService.listarActivas();
    }

    @GetMapping("/{id}")
    public SesionTutoriaEntity obtenerPorId(@PathVariable Long id) {
        return sesionTutoriaService.buscarPorId(id);
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public List<SesionTutoriaEntity> listarPorEstudiante(@PathVariable Long idEstudiante) {
        return sesionTutoriaService.listarPorIdEstudiante(idEstudiante);
    }

    @GetMapping("/tutor/{idTutor}")
    public List<SesionTutoriaEntity> listarPorTutor(@PathVariable Long idTutor) {
        return sesionTutoriaService.listarPorIdTutor(idTutor);
    }

    @PostMapping
    public SesionTutoriaEntity registrar(@RequestBody SesionTutoriaEntity sesion) {
        return sesionTutoriaService.registrar(sesion);
    }

    @PutMapping("/{id}")
    public SesionTutoriaEntity actualizar(@PathVariable Long id, @RequestBody SesionTutoriaEntity sesion) {
        return sesionTutoriaService.actualizar(id, sesion);
    }

    @DeleteMapping("/{id}")
    public void eliminarLogico(@PathVariable Long id) {
        sesionTutoriaService.eliminarLogico(id);
    }
}
