package com.hospital.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}