package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Dto.teusuarioDto;
import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Service.teusuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") long id) {
        if (usuarioService.listId(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el usuario con id: " + id);
        }
        usuarioService.delete(id);
        return "Usuario eliminado";
    }
    @GetMapping("/listar_usuario/{id}")
    public teusuarioEntity listar_por_id(@PathVariable("id") long id) {
        teusuarioEntity usuario = usuarioService.listId(id);
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el usuario con id: " + id);
        }
        return usuario;
    }
    @PutMapping("/modificar")
    public teusuarioEntity modificar(@RequestBody teusuarioEntity usuario) {
        if (usuario.getIdusuario() == null || usuarioService.listId(usuario.getIdusuario()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el usuario");
        }
        return usuarioService.guardar(usuario);
    }












}
