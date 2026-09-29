package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Service.teusuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name="controlador de usuarios", description = "aca se agrupara los datos de nuestros usuarios")

public class teusuarioController {

    @Autowired
    private teusuarioService teusuarioService;
    @GetMapping("/listar_usuarios")
   public List<teusuarioEntity>Listar_usuarios() {
        List<teusuarioEntity> listar_nuevo = new ArrayList<>();
        listar_nuevo = teusuarioService.listar();
        return listar_nuevo;


    }
    @PostMapping("/saveusuario")
    public teusuarioEntity guardar_usuario(@RequestBody teusuarioEntity teusuario){
        System.out.println(teusuario);
        return teusuarioService.guardar(teusuario);
    }
    

}
