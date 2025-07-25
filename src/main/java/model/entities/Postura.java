package model.entities;

import java.io.Serializable;

public class Postura implements Serializable {

	private int id;
	private String nombre;
	private String fotoUrl;
	private String videoUrl;
	private String instrucciones;
	private String beneficios;

	public Postura() {

	}

	public Postura(int id, String nombre, String fotoUrl, String videoUrl, String instrucciones, String beneficios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fotoUrl = fotoUrl;
		this.videoUrl = videoUrl;
		this.instrucciones = instrucciones;
		this.beneficios = beneficios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getInstrucciones() {
		return instrucciones;
	}

	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

}
