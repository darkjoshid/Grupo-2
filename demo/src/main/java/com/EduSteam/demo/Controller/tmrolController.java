package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Entity.tmrolEntity;
import com.EduSteam.demo.Repository.tmrolRepository;
import com.EduSteam.demo.Service.tmrolService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tmrol")
@Tag(name="Controlador de los roles", description = "Es el controlador que te permite registrar y listar los roles")
public class tmrolController {
    @Autowired
    private tmrolService rolService;

    @GetMapping("listar_roles")
    public List<tmrolEntity> listar_roles(){

        List<tmrolEntity> listar_nuevo = new ArrayList<>();

        listar_nuevo = rolService.listar();

        return listar_nuevo;

    }
    @PostMapping("/guardardatos")
    public tmrolEntity guardar_datos(@RequestBody tmrolEntity tmrol){

        System.out.println(tmrol);
        return rolService.guardar(tmrol);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        if (rolService.listarId(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el rol con id: " + id);
        }
        rolService.delete(id);
        return "Rol eliminado";
    }
    @GetMapping("/listar_usuario/{id}")
    public tmrolEntity listar_por_id(@PathVariable("id") Integer id) {
        tmrolEntity tmrol = rolService.listarId(id);
        if (tmrol == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el rol con id: " + id);
        }
        return tmrol;
    }
    @PutMapping("/modificar")
    public tmrolEntity modificar(@RequestBody tmrolEntity tmrl) {
        if (tmrl.getIdrol() == null || rolService.listarId(tmrl.getIdrol()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el usuario");
        }
        return rolService.guardar(tmrl);
    }

}