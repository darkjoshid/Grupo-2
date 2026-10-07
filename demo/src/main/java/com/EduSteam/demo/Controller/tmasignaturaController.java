package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Dto.tmasignaturaDto;
import com.EduSteam.demo.Service.tmasignaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
@Tag(name = "Controlador de asignaturas", description = "Permite registrar, listar, consultar, " +
        "actualizar y dar de baja las asignaturas")
public class tmasignaturaController {
    private final tmasignaturaService asignaturaService;

    public tmasignaturaController(tmasignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @GetMapping
    @Operation(summary = "Listar todas las asignaturas")
    public List<tmasignaturaDto> listar() {
        return asignaturaService.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una asignatura por su id")
    public tmasignaturaDto obtenerPorId(@PathVariable Long id) {
        return asignaturaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registrar una asignatura", description = "Requiere el idtutor de un tutor existente")
    public tmasignaturaDto guardar(@Valid @RequestBody tmasignaturaDto dto) {
        return asignaturaService.guardar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una asignatura", description = "Si se envía idtutor, la asignatura pasa a ese tutor")
    public tmasignaturaDto actualizar(@PathVariable Long id, @Valid @RequestBody tmasignaturaDto dto) {
        return asignaturaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Dar de baja una asignatura", description = "Eliminación lógica: la asignatura queda con estadoAsignatura = false")
    public void eliminar(@PathVariable Long id) {
        asignaturaService.eliminar(id);
    }
}
