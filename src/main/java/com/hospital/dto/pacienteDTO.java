package com.hospital.dto;

public class pacienteDTO {
	
	private Long id;
	private String nombre;
	private int edad;
	private String eps;
	private String telefono;
	private String correo;

	public pacienteDTO() {}
	
		
	public pacienteDTO(long id, String nombre, int edad, String eps, String telefono, String correo) {
			this.id = id;
			this.nombre = nombre;
			this.edad = edad;
			this.eps = eps;
			this.telefono = telefono;
			this.correo = correo;
		}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	
}

