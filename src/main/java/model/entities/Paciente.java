package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Paciente implements Serializable {

	private String id;
	private String nombre;
	private String correo;
	private String telefono;
	private String contraseña;
	private Instructor instructor;
	private Date fechaNacimiento;
	private char genero;
	private Serie serieAsignada;
	private List<Sesion> historialSesiones;

	public Paciente() {
		
	}
	
	public Paciente(String id, String nombre, String correo, String telefono, String contraseña, Instructor instructor,
			Date fechaNacimiento, char genero, Serie serieAsignada, List<Sesion> historialSesiones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.contraseña = contraseña;
		this.instructor = instructor;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.serieAsignada = serieAsignada;
		this.historialSesiones = historialSesiones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public Serie getSerieAsignada() {
		return serieAsignada;
	}

	public void setSerieAsignada(Serie serieAsignada) {
		this.serieAsignada = serieAsignada;
	}

	public List<Sesion> getHistorialSesiones() {
		return historialSesiones;
	}

	public void setHistorialSesiones(List<Sesion> historialSesiones) {
		this.historialSesiones = historialSesiones;
	}

}
