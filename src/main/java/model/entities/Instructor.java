package model.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "instructor")
public class Instructor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "cedula", nullable = false, unique = true)
    private String cedula;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "contrasena", nullable = false)
    private String password;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Lob
    @Column(name = "documentoEspecialidad", columnDefinition = "LONGBLOB")
    private byte[] documentoEspecialidad;

    // Constructor vacío obligatorio para JPA
    public Instructor() {
    }

    // Getters y setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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
