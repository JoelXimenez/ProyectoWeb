package model.dao;

import java.util.List;

import model.entities.Paciente;

public interface PacienteDAO {
	
	public void crear(Paciente p);
	public void actualizar (Paciente p);
	public void consultar (int id);
	public List<Paciente> getPacientes();
}
