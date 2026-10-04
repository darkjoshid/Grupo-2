package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.tmrolEntity;
import com.EduSteam.demo.Repository.tmrolRepository;
import com.EduSteam.demo.Service.tmrolService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/saveroles")
    public tmrolEntity guardar_datos(@RequestBody tmrolEntity tmrol){

        System.out.println(tmrol);
        return rolService.guardar(tmrol);
    }


}
