package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Service.teusuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name="Controlador de usuarios", description = "Es el controlador que te permite registrar y listar los usuarios")
public class teusuarioController {

    @Autowired
    private teusuarioService usuarioService;


    @GetMapping("listar_usuario")
    public List<teusuarioEntity> listar_usuarios(){

        List<teusuarioEntity> listar_nuevo = new ArrayList<>();

        listar_nuevo = usuarioService.listar();

        return listar_nuevo;

    }

    @PostMapping("/saveusuario")
    public teusuarioEntity guardar_datos(@RequestBody teusuarioEntity teusuario) {

        //PersonaEntity persona_nueva = service.guardar(persona);
        System.out.println(teusuario);
        return usuarioService.guardar(teusuario);
    }


}
