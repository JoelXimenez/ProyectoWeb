package model.entities;

import java.io.Serializable;
import java.util.List;

public class Serie implements Serializable {

	private String id;
	private Instructor instructor;
	private String nombre;
	private int numeroSesionesRecomendadas;
	private List<Postura> posturas;
	private int sesionesCompletadas;
	private int sesionesTotales;

	public Serie() {

	}

	public Serie(String id, Instructor instructor, String nombre, int numeroSesionesRecomendadas,
			List<Postura> posturas, int sesionesCompletadas, int sesionesTotales) {
		super();
		this.id = id;
		this.instructor = instructor;
		this.nombre = nombre;
		this.numeroSesionesRecomendadas = numeroSesionesRecomendadas;
		this.posturas = posturas;
		this.sesionesCompletadas = sesionesCompletadas;
		this.sesionesTotales = sesionesTotales;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroSesionesRecomendadas() {
		return numeroSesionesRecomendadas;
	}

	public void setNumeroSesionesRecomendadas(int numeroSesionesRecomendadas) {
		this.numeroSesionesRecomendadas = numeroSesionesRecomendadas;
	}

	public List<Postura> getPosturas() {
		return posturas;
	}

	public void setPosturas(List<Postura> posturas) {
		this.posturas = posturas;
	}

	public int getSesionesCompletadas() {
		return sesionesCompletadas;
	}

	public void setSesionesCompletadas(int sesionesCompletadas) {
		this.sesionesCompletadas = sesionesCompletadas;
	}

	public int getSesionesTotales() {
		return sesionesTotales;
	}

	public void setSesionesTotales(int sesionesTotales) {
		this.sesionesTotales = sesionesTotales;
	}

}
