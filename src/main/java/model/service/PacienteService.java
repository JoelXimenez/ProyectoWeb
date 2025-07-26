package model.service;
import model.entities.Paciente;
import model.dao.PacienteDAO;

public class PacienteService {
    private PacienteDAO pacienteDAO;

    public PacienteService() {pacienteDAO = new PacienteDAO();}


    public boolean guardar(Paciente paciente) {
        return pacienteDAO.create(paciente);
    }

}
