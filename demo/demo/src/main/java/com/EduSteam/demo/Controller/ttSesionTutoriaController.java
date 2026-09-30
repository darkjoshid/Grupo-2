package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.ttSesionTutoriaEntity;
import com.EduSteam.demo.Service.ttSesionTutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sesion_tutoria")
public class ttSesionTutoriaController {

    @Autowired
    private ttSesionTutoriaService sesionService;

    @GetMapping
    public List<ttSesionTutoriaEntity> listar() {
        return sesionService.listar();
    }

    @PostMapping
    public ttSesionTutoriaEntity guardar(@RequestBody ttSesionTutoriaEntity sesion) {
        return sesionService.guardar(sesion);
    }

    @GetMapping("/estado")
    public List<ttSesionTutoriaEntity> buscarPorEstado(@PathVariable String estado) {
        return sesionService.buscarPorEstado(estado);
    }

    @GetMapping("/estudiante")
    public List<ttSesionTutoriaEntity> buscarPorEstudiante(@PathVariable Integer idEstudiante) {
        return sesionService.buscarPorEstudiante(idEstudiante);
    }

}
