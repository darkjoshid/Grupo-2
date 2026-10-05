package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Dto.tetutorDto;
import com.EduSteam.demo.Service.tetutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
@Tag(name = "Controlador de tutores", description = "Permite registrar, listar, consultar, " +
        "actualizar y dar de baja a los tutores")
public class tetutorController {
    private final tetutorService tutorService;

    public tetutorController(tetutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los tutores")
    public List<tetutorDto> listar() {
        return tutorService.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un tutor por su id")
    public tetutorDto obtenerPorId(@PathVariable Long id) {
        return tutorService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registrar un tutor", description = "Requiere el idusuario de un usuario existente que aún no sea tutor")
    public tetutorDto guardar(@Valid @RequestBody tetutorDto dto) {
        return tutorService.guardar(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un tutor", description = "Si se envía idusuario, el tutor pasa a ese usuario (debe existir y no ser tutor de otro registro)")
    public tetutorDto actualizar(@PathVariable Long id, @Valid @RequestBody tetutorDto dto) {
        return tutorService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Dar de baja a un tutor", description = "Eliminación lógica: el tutor queda con estadoTutor = false")
    public void eliminar(@PathVariable Long id) {
        tutorService.eliminar(id);
    }
}
