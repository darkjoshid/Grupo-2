package com.prueba.demo.Controller;

import com.prueba.demo.Entity.AutorEntity;
import com.prueba.demo.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping("listar")
    public List<AutorEntity> upc_nuevo(){
        System.out.println("Mira por favor");
        List<AutorEntity> listar_nuevo = service.listar();

        return listar_nuevo;

    }

}
