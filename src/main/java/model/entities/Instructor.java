package model.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "idUsuario", column = @Column(name = "idInstructor"))
})
public class Instructor extends Usuario {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Paciente> pacientes;

    @Lob
    @Column(name = "documento_especialidad")
    private byte[] documentoEspecialidad;

    public Instructor() {
    }

    public Instructor(int idUsuario, String cedula, String nombreCompleto, String correo, String contrasena,
            String telefono, byte[] documentoEspecialidad) {
        super(idUsuario, cedula, nombreCompleto, correo, contrasena, telefono);
        this.documentoEspecialidad = documentoEspecialidad;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public byte[] getDocumentoEspecialidad() {
        return documentoEspecialidad;
    }

    public void setDocumentoEspecialidad(byte[] documentoEspecialidad) {
        this.documentoEspecialidad = documentoEspecialidad;
    }

}
