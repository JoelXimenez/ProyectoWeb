package model.entities;
import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
@AttributeOverrides({
        @AttributeOverride(name = "idUsuario", column = @Column(name = "idPaciente"))
})
public class Paciente extends Usuario {
    @Column(name = "genero")
    protected String genero;

    @Column(name = "fechaNacimiento")
    protected LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "idInstructor")
    private Instructor instructor;

    public Paciente() {}

    public Paciente(int idUsuario, String cedula, String nombreCompleto, String correo, String contrasena,
            String telefono, String genero, LocalDate fechaNacimiento, Instructor instructor) {
        super(idUsuario, cedula, nombreCompleto, correo, contrasena, telefono);
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.instructor = instructor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }





}
