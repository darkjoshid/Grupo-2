package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.tepadreEntity;
import com.EduSteam.demo.Service.tepadreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/padres")
@Tag(name="Controlador de padres", description = "Es el controlador que te permite registrar y listar los padres")
public class tepadreController {

    @Autowired
    private tepadreService padreService;

    @GetMapping("listar_padre")
    public List<tepadreEntity> listar_padres(){

        List<tepadreEntity> listar_nuevo = new ArrayList<>();

        listar_nuevo = padreService.listar();

        return listar_nuevo;

    }

    @PostMapping("/savepadre")
    public tepadreEntity guardar_datos(@RequestBody tepadreEntity tepadre) {

        System.out.println(tepadre);
        return padreService.guardar(tepadre);
    }

}
