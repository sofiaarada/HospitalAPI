package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.entity.Paciente;
import com.hospital.service.PacienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pacientes")
@Tag(name = "Pacientes", description = "Operaciones CRUD de pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Operation(summary = "Crear un nuevo paciente")
    @PostMapping
    public ResponseEntity<Paciente> crear(@Valid @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @Operation(summary = "Listar todos los pacientes")
    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @Operation(summary = "Buscar paciente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Actualizar paciente por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id,
                                               @Valid @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.actualizarPaciente(id, paciente));
    }

    @Operation(summary = "Eliminar paciente por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}