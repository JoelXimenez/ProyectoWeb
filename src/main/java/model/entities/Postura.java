package model.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Postura")
public class Postura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "foto_url")
    private String fotoUrl;

    @Column(name = "video_url")
    private String videoUrl;

    @Lob
    @Column(name = "instrucciones")
    private String instrucciones;

    @Lob
    @Column(name = "beneficios")
    private String beneficios;
    
    @Column(name = "duracion")
    private int duracion;

    // Constructor, getters y setters...

	public Postura(int id, String nombre, String fotoUrl, String videoUrl, String instrucciones, String beneficios, int duracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fotoUrl = fotoUrl;
		this.videoUrl = videoUrl;
		this.instrucciones = instrucciones;
		this.beneficios = beneficios;
		this.duracion = duracion;
	}


	public Postura() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public int getDuracion() {
	    return duracion;
	}

	public void setDuracion(int duracion) {
	    this.duracion = duracion;
	}

	public String getBeneficios() {
		return beneficios;
	}


	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
    
}
