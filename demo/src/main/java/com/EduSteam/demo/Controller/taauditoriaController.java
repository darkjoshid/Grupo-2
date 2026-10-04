package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Entity.taauditoriaEntity;
import com.EduSteam.demo.Service.taauditoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taauditoria")
@Tag(name="Controlador de las auditorias", description = "Es el controlador que te permite eliminar y listar las auditorias")
public class taauditoriaController {
    @Autowired
    private taauditoriaService service;
    @GetMapping("listarauditoria")
    public List<taauditoriaEntity> listarauditoria() {
        return service.listarAuditoria();
    }
    @DeleteMapping("eliminarauditoria/{idauditoria}")
    public void eliminarauditoria(@PathVariable Integer idauditoria) {
        service.eliminarAuditoria(idauditoria);
    }

}
