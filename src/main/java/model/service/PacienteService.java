package model.service;

import model.entities.Paciente;
import model.dao.PacienteDAO;

import java.sql.SQLException;
import java.util.List;

public class PacienteService {
    private PacienteDAO pacienteDAO;

    public PacienteService() {
        pacienteDAO = new PacienteDAO();
    }

    public boolean guardar(Paciente paciente) {
        return pacienteDAO.create(paciente);
    }

    public boolean guardarExistente(Paciente paciente) {
        return pacienteDAO.update(paciente);
    }

    public List<Paciente> listarPorInstructor(String cedulaInstructor) throws SQLException {
        return pacienteDAO.getPacientesByInstructor(cedulaInstructor);
    }

    public Paciente authenticate(String correo, String contrasena) {
        Paciente paciente = pacienteDAO.findByCorreo(correo);

        if (paciente != null && paciente.getContraseña().equals(contrasena)) {
            return paciente;
        }

        return null;
    }

    public Paciente buscarPacientePorId(String id) {
        return pacienteDAO.findById(id);
    }

    public Paciente buscarHistorialPorIdPaciente(String id) {
        return pacienteDAO.findHistorialById(id);
    }

}