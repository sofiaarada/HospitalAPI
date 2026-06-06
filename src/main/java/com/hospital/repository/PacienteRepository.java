package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.entity.Paciente;

public interface PacienteRepository 

	extends JpaRepository <Paciente, Long>{
		
	}

