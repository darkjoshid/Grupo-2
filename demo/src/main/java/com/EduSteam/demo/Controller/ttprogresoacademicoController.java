package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.ttprogresoacademicoEntity;
import com.EduSteam.demo.Service.ttprogresoacademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progresosacademicos")
public class ttprogresoacademicoController {
    @Autowired
    private ttprogresoacademicoService progresoAcademicoService;

    @GetMapping
    public List<ttprogresoacademicoEntity> listarActivos() {
        return progresoAcademicoService.listarActivos();
    }

    @GetMapping("/{id}")
    public ttprogresoacademicoEntity obtenerPorId(@PathVariable Long id) {
        return progresoAcademicoService.buscarPorId(id);
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public List<ttprogresoacademicoEntity> listarPorEstudiante(@PathVariable Long idEstudiante) {
        return progresoAcademicoService.listarPorIdEstudiante(idEstudiante);
    }

    @PostMapping
    public ttprogresoacademicoEntity registrar(@RequestBody ttprogresoacademicoEntity progreso) {
        return progresoAcademicoService.registrar(progreso);
    }

    @PutMapping("/{id}")
    public ttprogresoacademicoEntity actualizar(@PathVariable Long id, @RequestBody ttprogresoacademicoEntity progreso) {
        return progresoAcademicoService.actualizar(id, progreso);
    }

    @DeleteMapping("/{id}")
    public void eliminarLogico(@PathVariable Long id) {
        progresoAcademicoService.eliminarLogico(id);
    }
}
