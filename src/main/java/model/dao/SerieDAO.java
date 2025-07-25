package model.dao;

import java.util.List;

import model.entities.Postura;
import model.entities.Serie;

public interface SerieDAO {

	public void crear(Serie s);
	public List<Serie> getSeries();
	public Postura getSiguientePostura();
}
