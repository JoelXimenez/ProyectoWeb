package model.dao;
import model.entities.Paciente;
public class PacienteDAO extends GenericDAO<Paciente> {
public PacienteDAO() {
        super(Paciente.class);
    }

    @Override
    public boolean create(Paciente entity) {
       
        return super.create(entity);
    }
    
}
