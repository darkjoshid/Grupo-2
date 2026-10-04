package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.teestudianteEntity;
import com.EduSteam.demo.Service.teestudianteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@Tag(name="Controlador de estudiantes", description = "Es el controlador que te permite registrar y listar los estudiantes")
public class teestudianteController {

    @Autowired
    private teestudianteService estudianteService;

    @GetMapping("listar_estudiante")
    public List<teestudianteEntity> listar_estudiantes(){

        List<teestudianteEntity> listar_nuevo = new ArrayList<>();

        listar_nuevo = estudianteService.listar();

        return listar_nuevo;

    }

    @PostMapping("/saveestudiante")
    public teestudianteEntity guardar_datos(@RequestBody teestudianteEntity teestudiante) {

        System.out.println(teestudiante);
        return estudianteService.guardar(teestudiante);
    }

    @PutMapping("actualizarestudiante")
    public teestudianteEntity actualizar_datos(@RequestBody teestudianteEntity teestudiante) {

        System.out.println(teestudiante);
        return estudianteService.actualizar(teestudiante);
    }

    @DeleteMapping("eliminarestudiante/{idestudiante}")
    public void eliminar_estudiante(@PathVariable("idestudiante") Long idestudiante) {

        estudianteService.eliminar(idestudiante);
    }

}
