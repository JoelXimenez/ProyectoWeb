package model.service;

import model.dao.PacienteDAO;
import model.entities.Instructor;
import model.entities.Paciente;
import model.entities.Usuario;



import model.dao.InstructorDAO;

public class UsuarioService {
    private final PacienteDAO pacienteDAO;
    private final InstructorDAO instructorDAO;

    public UsuarioService() {
        pacienteDAO = new PacienteDAO();
        instructorDAO = new InstructorDAO();
    }

    public Usuario authenticate(String correo, String contrasena, String rol) {
        if ("paciente".equalsIgnoreCase(rol)) {
            Paciente paciente = pacienteDAO.findByCorreo(correo);
            if (paciente != null && contrasena.equals(paciente.getContrasena())) {
                return paciente;
            }
        } else if ("instructor".equalsIgnoreCase(rol)) {
            Instructor instructor = instructorDAO.findByCorreo(correo);
            if (instructor != null && contrasena.equals(instructor.getContrasena())) {
                return instructor;
            }
        }
        return null;
    }

}
