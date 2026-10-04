package com.example.demo.Controller;

import com.example.demo.Entity.ProgresoAcademicoEntity;
import com.example.demo.Service.ProgresoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progresosacademicos")
public class ProgresoAcademicoController {
    @Autowired
    private ProgresoAcademicoService progresoAcademicoService;

    @GetMapping
    public List<ProgresoAcademicoEntity> listarActivos() {
        return progresoAcademicoService.listarActivos();
    }

    @GetMapping("/{id}")
    public ProgresoAcademicoEntity obtenerPorId(@PathVariable Long id) {
        return progresoAcademicoService.buscarPorId(id);
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public List<ProgresoAcademicoEntity> listarPorEstudiante(@PathVariable Long idEstudiante) {
        return progresoAcademicoService.listarPorIdEstudiante(idEstudiante);
    }

    @PostMapping
    public ProgresoAcademicoEntity registrar(@RequestBody ProgresoAcademicoEntity progreso) {
        return progresoAcademicoService.registrar(progreso);
    }

    @PutMapping("/{id}")
    public ProgresoAcademicoEntity actualizar(@PathVariable Long id, @RequestBody ProgresoAcademicoEntity progreso) {
        return progresoAcademicoService.actualizar(id, progreso);
    }

    @DeleteMapping("/{id}")
    public void eliminarLogico(@PathVariable Long id) {
        progresoAcademicoService.eliminarLogico(id);
    }
}
