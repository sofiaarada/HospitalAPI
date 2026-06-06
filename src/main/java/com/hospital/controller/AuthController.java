package com.hospital.controller;

import com.hospital.entity.Usuario;
import com.hospital.repository.UsuarioRepository;
import com.hospital.security.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticación", description = "Registro e inicio de sesión")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Operation(summary = "Registrar nuevo usuario")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    @Operation(summary = "Iniciar sesión y obtener token JWT")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioEncontrado = 
            usuarioRepository.findByUsername(usuario.getUsername());

        if (usuarioEncontrado.isPresent() &&
            passwordEncoder.matches(usuario.getPassword(), 
                                    usuarioEncontrado.get().getPassword())) {
            String token = jwtUtil.generarToken(usuario.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body("Credenciales incorrectas");
    }
}