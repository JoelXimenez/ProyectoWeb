package model.service;
import model.entities.Paciente;
import model.dao.PacienteDAO;

import java.sql.SQLException;
import java.util.List;

public class PacienteService {
    private PacienteDAO pacienteDAO;

    public PacienteService() {pacienteDAO = new PacienteDAO();}


    public boolean guardar(Paciente paciente) {
        return pacienteDAO.create(paciente);
    }

    public List<Paciente> listarPorInstructor(int idInstructor) throws SQLException {
        return pacienteDAO.findByInstructor(idInstructor);
    }

}
