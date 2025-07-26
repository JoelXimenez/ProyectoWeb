package model.entities;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "series")
public class Serie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idInstructor")
	private Instructor instructor;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "numeroSesionesRecomendadas")
	private int numeroSesionesRecomendadas;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "serie_postura",
			joinColumns = @JoinColumn(name = "idSerie"),
			inverseJoinColumns = @JoinColumn(name = "idPostura")
	)
	private List<Postura> posturas;

	@Transient
	private int sesionesCompletadas;

	@Transient
	private int sesionesTotales;

	public Serie() {}

	public Serie(String id, Instructor instructor, String nombre, int numeroSesionesRecomendadas,
				 List<Postura> posturas, int sesionesCompletadas, int sesionesTotales) {
		this.id = id;
		this.instructor = instructor;
		this.nombre = nombre;
		this.numeroSesionesRecomendadas = numeroSesionesRecomendadas;
		this.posturas = posturas;
		this.sesionesCompletadas = sesionesCompletadas;
		this.sesionesTotales = sesionesTotales;
	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public Instructor getInstructor() { return instructor; }
	public void setInstructor(Instructor instructor) { this.instructor = instructor; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public int getNumeroSesionesRecomendadas() { return numeroSesionesRecomendadas; }
	public void setNumeroSesionesRecomendadas(int numeroSesionesRecomendadas) { this.numeroSesionesRecomendadas = numeroSesionesRecomendadas; }
	public List<Postura> getPosturas() { return posturas; }
	public void setPosturas(List<Postura> posturas) { this.posturas = posturas; }
	public int getSesionesCompletadas() { return sesionesCompletadas; }
	public void setSesionesCompletadas(int sesionesCompletadas) { this.sesionesCompletadas = sesionesCompletadas; }
	public int getSesionesTotales() { return sesionesTotales; }
	public void setSesionesTotales(int sesionesTotales) { this.sesionesTotales = sesionesTotales; }
}