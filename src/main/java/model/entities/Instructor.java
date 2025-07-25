package model.entities;

import java.io.Serializable;

public class Instructor implements Serializable{

	private String nombre;
	private String id;
	private String correo;
	private String password;
	private String telefono;
	private byte[] documentoEspecialidad;
	
	public Instructor() {
		
	}
	
	public Instructor(String nombre, String id, String correo, String password, String telefono, byte[] documentoEspecialidad) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.correo = correo;
		this.password = password;
		this.telefono = telefono;
		this.documentoEspecialidad = documentoEspecialidad;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public byte[] getDocumentoEspecialidad() {
		return documentoEspecialidad;
	}
	public void setDocumentoEspecialidad(byte[] documentoEspecialidad) {
		this.documentoEspecialidad = documentoEspecialidad;
	}
}
