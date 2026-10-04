package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.ttcuentaEntity;
import com.EduSteam.demo.Service.ttcuentaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ttcuenta")
@Tag(name="Controlador de las cuentas", description = "Es el controlador que te permite registrar, eliminar y listar las cuentas")
public class ttcuentaController {
    @Autowired
    private ttcuentaService service;
    @GetMapping("listarcuentas")
    public List<ttcuentaEntity>listarcuentas(){
        List<ttcuentaEntity>listar_nuevo=new ArrayList<>();
        listar_nuevo=service.ListarCuenta();
        return listar_nuevo;
    }
    @PostMapping("guardaractualizarcuentas")
    public ttcuentaEntity guardaractualizarcuentas(@RequestBody ttcuentaEntity ttcuenta){
        System.out.println(ttcuenta);
        return service.GuardarActualizar(ttcuenta);
    }
    @DeleteMapping("eliminarcuenta/{idcuenta}")
    public void eliminarcuenta(@PathVariable("idcuenta") Integer idcuenta){
        service.EliminarCuenta(idcuenta);
    }
}
