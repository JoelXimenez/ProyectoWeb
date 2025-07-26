package model.entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "posturas")
public class Postura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fotoUrl")
	private String fotoUrl;

	@Column(name = "videoUrl")
	private String videoUrl;

	@Column(name = "instrucciones", columnDefinition = "TEXT")
	private String instrucciones;

	@Column(name = "beneficios", columnDefinition = "TEXT")
	private String beneficios;

	public Postura() {}

	public Postura(int id, String nombre, String fotoUrl, String videoUrl, String instrucciones, String beneficios) {
		this.id = id;
		this.nombre = nombre;
		this.fotoUrl = fotoUrl;
		this.videoUrl = videoUrl;
		this.instrucciones = instrucciones;
		this.beneficios = beneficios;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getFotoUrl() { return fotoUrl; }
	public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
	public String getVideoUrl() { return videoUrl; }
	public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
	public String getInstrucciones() { return instrucciones; }
	public void setInstrucciones(String instrucciones) { this.instrucciones = instrucciones; }
	public String getBeneficios() { return beneficios; }
	public void setBeneficios(String beneficios) { this.beneficios = beneficios; }
}