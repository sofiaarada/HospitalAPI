package com.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Paciente;
import com.hospital.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente guardarPaciente(Paciente paciente) {
		
		return pacienteRepository.save(paciente);
	}
	
	public List<Paciente> listarPacientes(){
		return pacienteRepository.findAll();
	}
	
	public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    //Actualizar paciente
    public Paciente actualizarPaciente(Long id, Paciente datos) {
        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));

        paciente.setNombre(datos.getNombre());
        paciente.setEdad(datos.getEdad());
        paciente.setEps(datos.getEps());
        paciente.setTelefono(datos.getTelefono());
        paciente.setCorreo(datos.getCorreo());

        return pacienteRepository.save(paciente);
    }

    //Borrar paciente
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}

