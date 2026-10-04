package com.EduSteam.demo.Controller;


import com.EduSteam.demo.Entity.ttsesiontutoriaEntity;
import com.EduSteam.demo.Service.ttsesiontutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sesionestutoria")
public class ttsesiontutoriaController {

    @Autowired
    private ttsesiontutoriaService sesionTutoriaService;

    @GetMapping
    public List<ttsesiontutoriaEntity> listarActivas() {
        return sesionTutoriaService.listarActivas();
    }

    @GetMapping("/{id}")
    public ttsesiontutoriaEntity obtenerPorId(@PathVariable Long id) {
        return sesionTutoriaService.buscarPorId(id);
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public List<ttsesiontutoriaEntity> listarPorEstudiante(@PathVariable Long idEstudiante) {
        return sesionTutoriaService.listarPorIdEstudiante(idEstudiante);
    }

    @GetMapping("/tutor/{idTutor}")
    public List<ttsesiontutoriaEntity> listarPorTutor(@PathVariable Long idTutor) {
        return sesionTutoriaService.listarPorIdTutor(idTutor);
    }

    @PostMapping
    public ttsesiontutoriaEntity registrar(@RequestBody ttsesiontutoriaEntity sesion) {
        return sesionTutoriaService.registrar(sesion);
    }

    @PutMapping("/{id}")
    public ttsesiontutoriaEntity actualizar(@PathVariable Long id, @RequestBody ttsesiontutoriaEntity sesion) {
        return sesionTutoriaService.actualizar(id, sesion);
    }

    @DeleteMapping("/{id}")
    public void eliminarLogico(@PathVariable Long id) {
        sesionTutoriaService.eliminarLogico(id);
    }
}
