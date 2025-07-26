package model.entities;
import java.util.List;

import jakarta.persistence.*;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "idUsuario", column = @Column(name = "idInstructor"))
})
public class Instructor extends Usuario 
{
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Paciente> pacientes;

    public Instructor() {}



    public Instructor(int idUsuario, String cedula, String nombreCompleto, String correo, String contrasena,
            String telefono) {
        super(idUsuario, cedula, nombreCompleto, correo, contrasena, telefono);
    }



    public List<Paciente> getPacientes() {
        return pacientes;
    }

}
