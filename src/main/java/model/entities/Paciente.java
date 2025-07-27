package model.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Paciente")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    private String id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "genero")
    private char genero;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "serie_asignada_id")
    private Serie serieAsignada;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Sesion> historialSesiones;

    public Paciente() {}

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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Serie getSerieAsignada() {
		return serieAsignada;
	}

	public void setSerieAsignada(Serie serie) {
		this.serieAsignada = serie;
	}

	public List<Sesion> getHistorialSesiones() {
		return historialSesiones;
	}

	public void setHistorialSesiones(List<Sesion> historialSesiones) {
		this.historialSesiones = historialSesiones;
	}

	public Paciente(String id, String nombre, String correo, String telefono, String contraseña, Date fechaNacimiento,
			char genero, Instructor instructor, Serie serieAsignada, List<Sesion> historialSesiones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.contraseña = contraseña;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.instructor = instructor;
		this.serieAsignada = serieAsignada;
		this.historialSesiones = historialSesiones;
	}
    
	public boolean tieneSerieAsignada() {
	    return this.serieAsignada != null;
	}
    // Constructor, getters y setters...
    
}