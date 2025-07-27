package model.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Serie")
public class Serie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    private String id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "numero_sesiones_recomendadas")
    private int numeroSesionesRecomendadas;

    @Column(name = "sesiones_completadas")
    private int sesionesCompletadas;

    @Column(name = "sesiones_totales")
    private int sesionesTotales;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany
    @JoinTable(
        name = "serie_postura",
        joinColumns = @JoinColumn(name = "serie_id"),
        inverseJoinColumns = @JoinColumn(name = "postura_id")
    )
    private List<Postura> posturas;

    @OneToMany(mappedBy = "serie")
    private List<Sesion> sesiones;

    public Serie() {}
    // Constructor, getters y setters...

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

	public int getNumeroSesionesRecomendadas() {
		return numeroSesionesRecomendadas;
	}

	public void setNumeroSesionesRecomendadas(int numeroSesionesRecomendadas) {
		this.numeroSesionesRecomendadas = numeroSesionesRecomendadas;
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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Postura> getPosturas() {
		return posturas;
	}

	public void setPosturas(List<Postura> posturas) {
		this.posturas = posturas;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	public Serie(String id, String nombre, int numeroSesionesRecomendadas, int sesionesCompletadas, int sesionesTotales,
			Instructor instructor, List<Postura> posturas, List<Sesion> sesiones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroSesionesRecomendadas = numeroSesionesRecomendadas;
		this.sesionesCompletadas = sesionesCompletadas;
		this.sesionesTotales = sesionesTotales;
		this.instructor = instructor;
		this.posturas = posturas;
		this.sesiones = sesiones;
	}
    
}
