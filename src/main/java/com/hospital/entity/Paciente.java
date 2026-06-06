package com.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Min(value = 0, message = "La edad mínima es 0")
    @Max(value = 120, message = "La edad máxima es 120")
    private int edad;

    @NotBlank(message = "La EPS es obligatoria")
    private String eps;

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene formato válido")
    private String correo;

    // constructores, getters y setters igual que antes
    public Paciente() { }

    public Paciente(Long id, String nombre, int edad, String eps, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.eps = eps;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getEps() { return eps; }
    public void setEps(String eps) { this.eps = eps; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}